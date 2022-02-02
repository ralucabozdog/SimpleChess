package lab5;

public class Turn extends PiesaSah{

	public Turn(String culoare, char coloana) {
		this.numePiesa = "Turn";
		this.culoare = culoare;
		this.coloana = coloana;
		
		if(culoare == "alb")
			this.linie = 1;
		else
			this.linie = 8;
	}
	
	public Turn(String culoare, int linie, char coloana) {
		this.culoare = culoare;
		this.linie = linie;
		this.coloana = coloana;
	}
	
	public int mutaPiesa(int lin_noua, char col_noua, TablaSah sah) {
		
		if ( col_noua > 'h' || col_noua < 'a' || lin_noua > 8 || lin_noua <1)
			return 0;
		
		if (col_noua == coloana && lin_noua == linie)
			return 0;
		
		if (sah.tabla[lin_noua][col_noua - 'a' + 1] != null && sah.tabla[lin_noua][col_noua - 'a' + 1].culoare == this.culoare)
			return 0;
		
		if (culoare == "alb" && sah.tabla[lin_noua][col_noua - 'a' + 1] == sah.k)
			return 0;
		
		if (culoare == "negru" && sah.tabla[lin_noua][col_noua - 'a' + 1] == sah.K)
			return 0;
		
		if (col_noua == coloana && lin_noua != linie) {								//daca se deplaseaza pe aceeasi coloana
			
			if (lin_noua > linie) {													//verific directia in care ma deplasez, pentru a putea folosi corect iteratorul care parcurge liniile ( i++ sau i--  ?)
				for(int i = linie + 1; i<lin_noua; i++) {
					if(sah.tabla[i][coloana - 'a' + 1] != null)						//daca exista piesa in calea turnului, nu am o mutare valida
						return 0;
				}
																					//daca pana la noile coordonate nu intalnesc "obstacol" (piesa in cale)
				sah.tabla[linie][coloana - 'a' + 1] = null;							//mutarea este valida si se fac actualizarile necesare
				sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
				linie = lin_noua;
				coloana = col_noua;
				return 1;
			}
			
			else {
				for(int i = linie - 1; i>lin_noua; i--) {
					if(sah.tabla[i][coloana - 'a' + 1] != null)
						return 0;
				}
				sah.tabla[linie][coloana - 'a' + 1] = null;
				sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
				linie = lin_noua;
				coloana = col_noua;
				return 1;
			}
		}
		
		
		if (col_noua != coloana && lin_noua == linie) {								//daca se deplaseaza pe aceeasi linie
			
			if (col_noua > coloana) {
				for(int i = coloana + 1; i<col_noua; i++) {
					if(sah.tabla[linie][i - 'a' + 1] != null)
						return 0;
				}
				sah.tabla[linie][coloana - 'a' + 1] = null;
				sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
				linie = lin_noua;
				coloana = col_noua;
				return 1;
			}
			
			else {
				for(int i = coloana - 1; i>col_noua; i--) {
					if(sah.tabla[linie][i - 'a' + 1] != null)
						return 0;
				}
				sah.tabla[linie][coloana - 'a' + 1] = null;
				sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
				linie = lin_noua;
				coloana = col_noua;
				return 1;
			}
		}
		
		return 0;
	}
}
