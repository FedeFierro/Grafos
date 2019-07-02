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
		int[] distancias = matriz[nodo];
		boolean[] terminado = new boolean[distancias.length];
		PriorityQueue<NodoDijkstra> cola = new PriorityQueue<NodoDijkstra>();
		terminado[nodo] = true;
		for (int i = 0; i < distancias.length; i++) {
			if (!terminado[i])
				if (distancias[i] < MAX) {
					cola.add(new NodoDijkstra(i, distancias[i]));
				}
		}
		while (!cola.isEmpty()) {
			NodoDijkstra n = cola.poll();
			int w = n.numero;
			terminado[w] = true;
			for (int i = 0; i < distancias.length; i++) {
				if (!terminado[i]) {
					int d = distancias[i];
					int d1 = distancias[w] + matriz[w][i];
					if (d > d1) {
						distancias[i] = d1;
						NodoDijkstra nvo = new NodoDijkstra(i, distancias[i]);

						if (!cola.contains(nvo)) {
							cola.add(nvo);
						}
					}
				}
			}
		}
		return distancias;
	}

}
