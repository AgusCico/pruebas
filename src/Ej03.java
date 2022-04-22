
public class Ej03 {
//holas
//	Escribir un método en Java que de una matriz numérica dada, devuelva un vector con n elementos, donde cada elemento es la moda de una fila. 
//	Si hubiese más de una moda, se deberá utilizar la de mayor valor
//
//	Ejemplo:
//	Para la matriz
//	 1  2  3  4
//	 5 -6 -6 20
//	 1  1 10 10
//
//	La salida debe ser
//	4 -6 10
//TRABAJANDO EN RAMA MASTER
//TRABAJANDO DESDE LA PAGINA GIT HUB
//AGREGANDO CAMBIO EN RAMA NUEVA
	public static void imprimirVector(int[] vector) {

		for (int fila = 0; fila < vector.length; fila++) {

			System.out.print("  " + vector[fila]);
		}
		System.out.println();
	}

	public int cantidadPorFila(int[] vec, int num, int limiteInf, int limiteSup) {

		int cant = 0;

		for (int i = limiteInf; i < limiteSup; i++) {

			if (vec[i] == num)
				cant++;
		}

		return cant;
	}

	public int[] calcularModa(int[][] matriz) {

		int[] vec = new int[matriz.length];

		int cantidad, cantMaxima, numeroActual;

		for (int fila = 0; fila < matriz.length; fila++) {
			
			cantidad = 0;
			cantMaxima = 0;
			for (int colum = 0; colum < matriz[0].length; colum++) {

				numeroActual = matriz[fila][colum];
				if (numeroActual != vec[fila]) {

					cantidad = cantidadPorFila(matriz[fila], numeroActual, colum, matriz[0].length);

					if (cantMaxima == 0 || cantidad > cantMaxima || (cantidad == cantMaxima && vec[fila] < numeroActual)) {
						vec[fila] = numeroActual;
						cantMaxima = cantidad;
						cantidad = 0;
					} 
//					else if (vec[fila] == matriz[fila][colum]) {
//						cantMaxima++;
//					}
				}
				
			}
		}
		imprimirVector(vec);
		return vec;
	}

	public static void main(String[] args) {

		Ej03 ej = new Ej03();
		int[][] matPrueba = { { 1, 2, 3, 4 }, { 5, -6, -6, 20 }, { 1, 1, 10, 10 } };

		ej.calcularModa(matPrueba);
	}

}
