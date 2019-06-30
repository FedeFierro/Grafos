package djstra;

public class Djstra {
	Double[][] matriz;
	
	public Djstra(int[][]origen) {
		matriz = new Double[origen.length][origen[0].length];
		for(int i=0; i<matriz.length ;i++) {
			for(int j=0; j< matriz[i].length; j++) {
				Double valor = (double) origen[i][j];
				valor = valor==0 ? Double.POSITIVE_INFINITY: valor;
				matriz[i][j]=valor;
			}
		}
				
	}
	public Double[][] aplicar(){
		for(int i=0; i< matriz.length; i++) {
			for(int j=0; j< matriz[i].length; j++) {
				if(i!=j) {
					double valor = matriz[i][j];
					for(int z = 0; z < matriz[i].length; z++) {
						if(z!=i && z !=j) {
							double suma = matriz[i][z] + matriz[z][j];
							valor = valor < suma ?valor:suma;
						}
					}
					matriz[i][j]=valor;
				}
			}
		}
		return matriz;
	}

}
