package minotauro;

public class Nodo{


	int numero1;
	int numero2;
	int pasos;

	public Nodo(int num1, int num2, int pasos) {
		this.numero1 = num1;
		this.numero2 = num2;
		this.pasos = pasos;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof Nodo) {
			Nodo n = (Nodo) obj;
			if((this.numero1==n.numero1 && this.numero2==n.numero2)
					||(this.numero1==n.numero2 && this.numero2 == n.numero1)){
				return true;
			}
		}
		return false;
		
		
	}

}
