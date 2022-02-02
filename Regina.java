package lab5;

public class Regina extends PiesaSah{
	
	public Regina(String culoare) {
		this.numePiesa = "Regina";
		this.culoare = culoare;
		this.coloana = 'd';
		
		if(culoare == "alb")
			this.linie = 1;
		else 
			this.linie = 8;
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
		
		if (col_noua == coloana || lin_noua == linie){										//daca isi pastreaza linia sau coloana, regina are aceleasi miscari valide ca tura
			Turn R = new Turn(culoare, linie, coloana);
			if(R.mutaPiesa(lin_noua, col_noua, sah) == 1) {
				this.linie = R.linie;
				this.coloana = R.coloana;
				sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
				return 1;
			}
			return 0;
		}
		
		if (col_noua != coloana && lin_noua != linie) {										//daca isi modifica atat linia cat si coloana, regina are aceleasi miscari valide ca nebunul
			Nebun B = new Nebun (culoare, linie, coloana);
			if(B.mutaPiesa(lin_noua, col_noua, sah) == 1) {
				this.linie = B.linie;
				this.coloana = B.coloana;
				sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
				return 1;
			}
			return 0;
		}
		
		return 0;
	}
}
