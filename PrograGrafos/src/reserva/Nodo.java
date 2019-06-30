package reserva;

public class Nodo {
	int numero;
	int caminos;

	public Nodo(int numero) {
		this.numero = numero;
		this.caminos=0;
	}
	public void sumarCamino(int camino) {
		this.caminos+=camino;
	}
}

