package test;
import org.junit.*;

import dijkstra.*;

public class TestDijkstra {
	@Test
	public void test() {
		int[][]matriz= {{0,10,0,30,100},{0,0,50,0,0},{0,0,0,0,10},{0,0,20,0,60},{0,0,0,0,0}};
		Dijkstra d = new Dijkstra(matriz);
		
		Double[][] calculada=d.aplicar();
		
		for(int i=0; i< calculada.length;i++) {
			for(int j=0; j< calculada[i].length;j++) {
				System.out.print(calculada[i][j]+" ");
				
			}
			System.out.println("");
		}
		
	}
}
