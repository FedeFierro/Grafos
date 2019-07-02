package dijkstra;

import java.util.PriorityQueue;

import entidades.NodoDijkstra;

public class Dijkstra {
	int[][] matriz;
	final int MAX = Integer.MAX_VALUE / 3;

	public Dijkstra(int[][] origen) {
		matriz = new int[origen.length][origen[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				int valor = origen[i][j];
				valor = valor == 0 ? MAX : valor;
				matriz[i][j] = valor;
			}
		}

	}

	public int[][] aplicar() {
		for (int i = 0; i < matriz.length; i++) {
			matriz[i] = aplicarNodo(i);
		}
		return matriz;
	}

	public int[] aplicarNodo(int nodo) {
		NodoDijkstra[] distancias = new NodoDijkstra[matriz[nodo].length];
		PriorityQueue<NodoDijkstra> cola = new PriorityQueue<NodoDijkstra>();
		for (int i = 0; i < matriz[nodo].length; i++) {
			NodoDijkstra n;
			int costo = matriz[nodo][i];
			if(i==nodo) {
				n= new NodoDijkstra(i, 0, true);
			}else {
				
				n = new NodoDijkstra(i, costo);
				if(costo<MAX) {
					cola.add(n);
				}
			}
			distancias[i]=n;
		}
		while (!cola.isEmpty()) {
			NodoDijkstra nw = cola.poll();
			int w = nw.numero;
			nw.terminado=true;
			for (int i = 0; i < distancias.length; i++) {
				NodoDijkstra ni=distancias[i];
				if(!ni.terminado) {
					int d = ni.costo;
					int d1 = nw.costo + matriz[w][i];
					if (d > d1) {
						ni.costo = d1;
					if (!cola.contains(ni)) {
							cola.add(ni);
						}
					}
				}
			}
		}
		int[] dis = new int[distancias.length];
		for(int i=0; i< dis.length;i++) {
			dis[i]=distancias[i].costo;
		}
		return dis;
	}

}
