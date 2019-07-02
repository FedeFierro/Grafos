package calles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import dijkstra.Dijkstra;

public class Calles {
	int esquinas;
	int salida;
	int escuela;
	int calles;
	int[][] nroCalles;
	int[][] original;
	int[][] simetrica;
	String fileName;
	
	public Calles(String fileName) {
		this.fileName = fileName;
		try {
			Scanner sc = new Scanner(new File(this.fileName+".in"));
			esquinas=sc.nextInt();
			salida=sc.nextInt()-1;
			escuela=sc.nextInt()-1;
			calles =sc.nextInt();
			original = new int[esquinas][esquinas];
			simetrica= new int[esquinas][esquinas];
			nroCalles = new int[esquinas][esquinas];
			
			for(int i =0;i<calles;i++) {
				int n1 = sc.nextInt()-1;
				int n2 =sc.nextInt()-1;
				int costo = sc.nextInt();
				original[n1][n2]=costo;
				nroCalles[n1][n2]=i+1;
				/*cargo la simetrica para suponer doble mano*/
				simetrica[n1][n2]=costo;
				simetrica[n2][n1]=costo;
			}
			sc.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void resolver() {
		/*mando la simetrica porque no me importa el sentido de las calles*/
		Dijkstra d = new Dijkstra(simetrica);
		int[][] caminos = d.aplicarObtenerCaminos(salida);
		ArrayList<Integer> caminoEscuela= new ArrayList<Integer>();
		int nodo = escuela;
		while(nodo!=salida) {
			caminoEscuela.add(nodo);
			nodo=caminos[1][nodo];
		}
		caminoEscuela.add(nodo);
		int costo = caminos[0][escuela];
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.fileName+".out"));
			pw.println(costo);
			for(int i=0;i<caminoEscuela.size()-1;i++) {
				int n1 = caminoEscuela.get(i);
				int n2 = caminoEscuela.get(i+1);
				if(original[n2][n1]==0) {
					pw.print(nroCalles[n1][n2]+" ");
				}
			}
			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
