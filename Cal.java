package lab5;

public class Cal extends PiesaSah{
	
	public Cal(String culoare, char coloana) {
		this.numePiesa = "Cal";
		this.culoare = culoare;
		this.coloana = coloana;
		
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
		
		if (col_noua == coloana && lin_noua != linie)										//calul nu pastreaza aceeasi coloana
			return 0;
		
		if (lin_noua == linie && col_noua != coloana)										//calul nu pastreaza aceeasi linie
			return 0;
		
		if (col_noua != coloana && lin_noua != linie) {
			if (Math.abs(col_noua - coloana) + Math.abs(lin_noua - linie) != 3)				//se deplaseaza 3 patrate in orice directie
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
