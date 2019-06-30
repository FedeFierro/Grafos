package minotauro;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Minotauro {
	int[][] matriz;
	int nodos;
	ArrayList<Nodo> resultado;
	String fileName;

	public Minotauro(String fileName) {
		try {
			this.fileName = fileName;
			Scanner sc = new Scanner(new File(this.fileName + ".in"));
			nodos = sc.nextInt();
			matriz = new int[nodos + 1][nodos + 1];
			for (int i = 1; i <= nodos; i++) {
				for (int j = 1; j <= nodos; j++) {
					matriz[i][j] = sc.nextInt();
				}
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void resolver() {
		aplicarDjstraInverso();
		armarResultado();
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.fileName+".out"));
			pw.println(resultado.size());
			for(Nodo n : resultado) {
				pw.println(n.numero1 +" "+ n.numero2 +" "+n.pasos);
			}
			pw.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void aplicarDjstraInverso() {
		for (int i = 1; i <= nodos; i++) {
			for (int j = 1; j <= nodos; j++) {
				int valor = matriz[i][j];
				if (valor > 0) {
					for (int z = 1; z <= nodos; z++) {
						int valor1 = matriz[i][z];
						int valor2 = matriz[z][j];
						if (valor1 > 0 && valor2 > 0 && valor1 + valor2 == valor) {
							matriz[i][j] = 0;
						}

					}
				}

			}
		}

	}
	private void armarResultado() {
		resultado= new ArrayList<Nodo>();
		
		for (int i = 1; i <= nodos; i++) {
			for (int j = 1; j <= nodos; j++) {
				if (matriz[i][j] > 0) {
					Nodo n = new Nodo(i,j,matriz[i][j]);
					if(!resultado.contains(n)) {
						resultado.add(n);
					}
				}
			}
			System.out.println("");
		}

	}
}
