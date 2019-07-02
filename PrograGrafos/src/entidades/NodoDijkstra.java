package entidades;

public class NodoDijkstra implements Comparable<NodoDijkstra>{
	public int numero;
	public int costo;
	public boolean terminado;
	public int padre;
	public NodoDijkstra(int num, int costo, int padre) {
		this.numero=num;
		this.costo=costo;
		this.terminado=false;
		this.padre=padre;
	}
	public NodoDijkstra(int num, int costo, int padre, boolean terminado) {
		this.numero=num;
		this.costo=costo;
		this.padre=padre;
		this.terminado=terminado;
	}
	@Override
	public int compareTo(NodoDijkstra o) {
		return (this.costo - o.costo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costo;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodoDijkstra other = (NodoDijkstra) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	
	
}
