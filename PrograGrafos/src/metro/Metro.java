package metro;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Metro {
	boolean[][] matrizTunel;
	boolean[][]matrizPuente;
	String fileName;
	int puentes;
	int nodos;
	
	public Metro(String fileName) {
		this.fileName=fileName;
		this.puentes=0;
		try {
			Scanner sc = new Scanner(new File(this.fileName+".in"));
			nodos=sc.nextInt();
			int t = sc.nextInt();
			int p = sc.nextInt();
			matrizTunel= new boolean[nodos+1][nodos+1];
			matrizPuente= new boolean[nodos+1][nodos+1];
			for(int i=0; i<t; i++) {
				int fila = sc.nextInt();
				int col = sc.nextInt();
				matrizTunel[fila][col]=true;
				matrizTunel[col][fila]=true;
				
			}
			for(int i=0; i<p; i++) {
				int fila = sc.nextInt();
				int col = sc.nextInt();
				matrizPuente[fila][col]=true;
				matrizPuente[col][fila]=true;
			}
			sc.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void resolver() {
		aplicarWarshall();
		while(colocarPuente()) {
			puentes++;
			aplicarWarshall();
		}
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.fileName+".out"));
			pw.println(puentes);
			pw.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void aplicarWarshall() {
		for(int i = 1; i <=nodos;i++ ) {
			for(int j=1; j<= nodos; j++) {
				if(i!=j && !matrizTunel[i][j]) {
					boolean camino;
					for(int z =1; z<=nodos;z++) {
						if(z!=j) {
							camino = matrizTunel[i][z] && matrizTunel[z][j];
							if(camino) {
								matrizTunel[i][j]=camino;
								matrizTunel[j][i]=camino;
								break;
							}
						}
					}
					
				}
				
			}
		}
	}
	
	public boolean colocarPuente() {
		for(int i=1; i<=nodos; i++) {
			for(int j=1;j<=nodos;j++) {
				if(i!=j) {
					if(!matrizTunel[i][j] && matrizPuente[i][j]) {
						matrizTunel[i][j]= matrizPuente[i][j];
						matrizTunel[j][i]=matrizPuente[i][j];
						return true;
					}
				}
			}
		}
		return false;
	}

}
