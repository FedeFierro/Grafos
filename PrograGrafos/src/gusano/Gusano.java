package gusano;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import dijkstra.Dijkstra;

public class Gusano {
	int aristas;
	int[][] matriz;
	int nodosInfectados;
	String fileName;
	int[][] arrayIn;
	int[][] infectados;
	Double[][] matrizCalculada;
	int[] soluciones;

	public Gusano(String fileName) {
		try {
			this.fileName = fileName;
			Scanner sc = new Scanner(new File(this.fileName + ".in"));
			aristas = sc.nextInt();
			int maxNodo = 0;
			arrayIn = new int[aristas][3];
			for (int i = 0; i < aristas; i++) {
				int nodo1 = sc.nextInt();
				int tiempo = sc.nextInt();
				int nodo2 = sc.nextInt();
				maxNodo = maxNodo > nodo1 ? maxNodo : nodo1;
				maxNodo = maxNodo > nodo2 ? maxNodo : nodo2;
				arrayIn[i][0] = nodo1;
				arrayIn[i][1] = nodo2;
				arrayIn[i][2] = tiempo;
			}
			crearMatriz(maxNodo);

			nodosInfectados = sc.nextInt();
			infectados = new int[nodosInfectados][2];
			for (int i = 0; i < nodosInfectados; i++) {
				infectados[i][0] = sc.nextInt();
				infectados[i][1] = sc.nextInt();
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void resolver() {
		Dijkstra d = new Dijkstra(matriz);
		matrizCalculada = d.aplicar();
		for (int i = 0; i < nodosInfectados; i++) {
			AgregarSoluciones(infectados[i][0], infectados[i][1]);
		}

		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.fileName + ".out"));
			for (int i = 0; i < soluciones.length; i++) {
				if (soluciones[i] == nodosInfectados) {
					pw.println((i + 1));
				}

			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void AgregarSoluciones(int n, int t) {
		for (int i = 0; i < matrizCalculada[n - 1].length; i++) {
			Double valor = matrizCalculada[n - 1][i];
			if (valor == t) {
				soluciones[i]++;
			}
		}
	}

	private void crearMatriz(int nodos) {
		matriz = new int[nodos][nodos];
		soluciones = new int[nodos];
		for (int i = 0; i < aristas; i++) {
			int n1 = arrayIn[i][0];
			int n2 = arrayIn[i][1];
			int t = arrayIn[i][2];
			matriz[n1 - 1][n2 - 1] = t;
			matriz[n2 - 1][n1 - 1] = t;
		}

	}

}
