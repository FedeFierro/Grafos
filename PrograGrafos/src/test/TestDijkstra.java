package test;
import org.junit.*;

import dijkstra.*;

public class TestDijkstra {
	int[][]matriz= {{0,10,0,30,100},{0,0,50,0,0},{0,0,0,0,10},{0,0,20,0,60},{0,0,0,0,0}};
	Dijkstra d;
	@Before
	public void iniciar() {
	    d = new Dijkstra(matriz);
	    System.out.println("MatrizOriginal");
	    for(int i=0; i<matriz.length;i++) {
	    	for(int j=0; j<matriz[i].length;j++) {
		    	System.out.print(matriz[i][j]+" ");
		    }	
	    	System.out.println("");
	    }
		
	}
	@Test
	public void test() {
		System.out.println("test completo");
		
		int[][] calculada=d.aplicar();
		
		for(int i=0; i< calculada.length;i++) {
			for(int j=0; j< calculada[i].length;j++) {
				System.out.print(calculada[i][j]+" ");
				
			}
			System.out.println("");
		}
		
	}
	@Test
	public void testNodo() {
		System.out.println("Test por Nodo");
		int[] distancia = d.aplicarNodo(0); 
		for(int i =0; i<distancia.length; i++) {
			System.out.print(distancia[i]+" ");
		}
		System.out.println(" ");
	}
		
}
