package reserva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Reserva {
	public int nodos;
	public int tramos;
	public int[][] grafo;
	public Nodo[] caminosArray;
	public Queue<Nodo> cola;
	public String fileName;
	
	public Reserva(String fileName) {
		
		try {
			this.fileName = fileName;
			Scanner sc = new Scanner(new File(this.fileName+".in"));
			nodos = sc.nextInt();
			tramos=sc.nextInt();
			grafo= new int[nodos+1][nodos+1];
			for(int i=0; i<tramos;i++) {
				int indiceI = sc.nextInt();
				int indiceJ = sc.nextInt();
				grafo[indiceI][indiceJ]=1;
			}
			sc.close();
			caminosArray= new Nodo[nodos+1];
			for(int i=1; i<=nodos; i++ ) {
				caminosArray[i]= new Nodo(i);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void resolver() {
		aplicarBFS();
		int result = caminosArray[nodos].caminos;
	
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.fileName+".out"));
			pw.println(result);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void aplicarBFS() {
		Nodo primerNodo = caminosArray[1];
		primerNodo.sumarCamino(1);
		cola = new LinkedList<Nodo>();
		cola.add(primerNodo);
		
		while(!cola.isEmpty()) {
			Nodo nodo =  cola.poll();
			int numNodo = nodo.numero;
			for(int i=1; i< grafo[numNodo].length; i++) {
				if(grafo[numNodo][i]==1) {
					Nodo ad = caminosArray[i];
					ad.sumarCamino(nodo.caminos);
					if(!cola.contains(ad)) {
						cola.add(ad);
					}
				}
			}
		}
		
	}
}
