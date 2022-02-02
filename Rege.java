package lab5;

public class Rege extends PiesaSah{
	
	public Rege(String culoare) {
		this.numePiesa = "Rege";
		this.culoare = culoare;
		this.coloana = 'e';
		
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
		
		if (col_noua != coloana && lin_noua == linie) {						//daca isi pastreaza linia
			if (Math.abs(col_noua - coloana) > 1)							//se poate deplasa exact un patrat pe aceeasi linie (pe coloane adiacente)
				return 0;
			sah.tabla[linie][coloana - 'a' + 1] = null;
			sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
			linie = lin_noua;
			coloana = col_noua;
			return 1;
		}
		
		if (col_noua == coloana && lin_noua != linie) {						//daca isi pastreaza coloana
			if (Math.abs(lin_noua - linie) > 1)								//se poate deplasa exact o casuta pe aceeasi coloana (pe linii vecine)
				return 0;
			sah.tabla[linie][coloana - 'a' + 1] = null;
			sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
			linie = lin_noua;
			coloana = col_noua;
			return 1;
		}
		
		if (col_noua != coloana && lin_noua != linie) {											//daca schimba ata linia cat si coloana
			if (Math.abs(lin_noua - linie) > 1  || Math.abs(col_noua - coloana) > 1)			//daca se deplaseaza mai mult de o casuta pe linie sau pe coloana, mutarea nu este valida
				return 0;
			sah.tabla[linie][coloana - 'a' + 1] = null;
			sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
			linie = lin_noua;
			coloana = col_noua;
			return 1;
		}
		return 0;
	}
}
