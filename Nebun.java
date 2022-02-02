package lab5;

public class Nebun extends PiesaSah{						//Nebun este o subclasa a clasei PiesaSah
	
	public Nebun(String culoare, char coloana) {			//Constructor cu 2 parametri (considerand ca incep un joc de sah de la capat, stiu pe ce linie se afla la inceput nebunul, nu trebuie sa specific eu la initializare)
		this.numePiesa = "Nebun";
		this.culoare = culoare;
		this.coloana = coloana;
		
		if(culoare == "alb")
			this.linie = 1;
		else
			this.linie = 8;
	}
	
	public Nebun(String culoare, int linie, char coloana) {					//Constructor cu 3 parametri, daca vreau sa verific o anumita mutare a nebunului, 
		this.culoare = culoare;												//nu vreau sa plec cu nebunul din pozitia initiala si apoi sa ii asigur "cale libera", ci pun nebunul direct la coordonatele dorite
		this.coloana = coloana;
		this.linie = linie;
	}
	
	
	public int mutaPiesa(int lin_noua, char col_noua, TablaSah sah) {
		
		if ( col_noua > 'h' || col_noua < 'a' || lin_noua > 8 || lin_noua <1)						//ies din tabla
			return 0;
		
		if (col_noua == coloana && lin_noua == linie)												//nu am mutare (raman pe aceeasi pozitie)
			return 0;
		
		if (sah.tabla[lin_noua][col_noua - 'a' + 1] != null && sah.tabla[lin_noua][col_noua - 'a' + 1].culoare == this.culoare)						//imi capturez o piesa proprie
			return 0;
		
		if (culoare == "alb" && sah.tabla[lin_noua][col_noua - 'a' + 1] == sah.k)
			return 0;																				//capturez regele adversarului
		
		if (culoare == "negru" && sah.tabla[lin_noua][col_noua - 'a' + 1] == sah.K)
			return 0;
				
		if (col_noua == coloana || lin_noua == linie)												//nebunul nu poate sa se deplaseze pe aceeasi linie sau pe aceeasi coloana
			return 0;

		
		if (lin_noua != linie && col_noua != coloana) {												//el trebuie sa se deplaseze diagonal (cu schimbare ambelor coordonate)
			
			if(Math.abs(lin_noua - linie) != Math.abs(col_noua - coloana))							//daca isi schimba ata linia cat si coloana, dar nu se deplaseza paralele cu diagonala tablei de sah
				return 0;
			 																						//trebuie sa nu existe piese care sa ii blocheze calea de la pozitia curenta, la cea dorita
			if(lin_noua > linie) {																	//analizez directia in care se doreste deplasarea nebunului
				if(col_noua > coloana) {
					int  i = linie + 1;
					int j = coloana + 1;
					
					while(i <= 8 && j<='h' && i < lin_noua && j < col_noua) {					//verific daca exista piesa care sa ii stea in drum
						if(sah.tabla[i][j - 'a' + 1] != null)									//daca drumul pana la noua pozitie nu ii este liber, nu este o mutare valida
							return 0;
						i++;
						j++;
					}
					sah.tabla[linie][coloana - 'a' + 1] = null;									//daca drumul este liber, locul de unde a plecat nebunul devine liber
					sah.tabla[lin_noua][col_noua - 'a' + 1] = this;								//nebunul se muta la noile coordonate
					linie = lin_noua;															//coordonatele ii sunt actualizate
					coloana = col_noua;
					return 1;
				}
				else {
					int  i = linie + 1;
					int j = coloana - 1;
					
					while(i <= 8 && j>='a' && i < lin_noua && j > col_noua) {
						if(sah.tabla[i][j - 'a' + 1] != null)
							return 0;
						i++;
						j--;
					}
					sah.tabla[linie][coloana - 'a' + 1] = null;
					sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
					linie = lin_noua;
					coloana = col_noua;
					return 1;
				}
			}
			else {
				if(col_noua > coloana) {
					int  i = linie - 1;
					int j = coloana + 1;
					
					while(i >=1 && j<='h' && i > lin_noua && j < col_noua) {
						if(sah.tabla[i][j - 'a' + 1] != null)
							return 0;
						i--;
						j++;
					}
					sah.tabla[linie][coloana - 'a' + 1] = null;
					sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
					linie = lin_noua;
					coloana = col_noua;
					return 1;
				}
				else {
					int  i = linie - 1;
					int j = coloana - 1;
					
					while(i >= 1 && j>='a' && i > lin_noua && j > col_noua) {
						if(sah.tabla[i][j - 'a' + 1] != null)
							return 0;
						i--;
						j--;
					}
					sah.tabla[linie][coloana - 'a' + 1] = null;
					sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
					linie = lin_noua;
					coloana = col_noua;
					return 1;
				}
			}
		}
		
		
		return 0;
	}
}
