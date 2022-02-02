package lab5;

public class Pion extends PiesaSah{				//Pion este o subclasa a clasei PiesaSah

	public Pion(String culoare, char coloana) {		//Constructorul clasei
		this.numePiesa = "Pion";
		this.culoare = culoare;
		this.coloana = coloana;

		if (culoare == "alb") {						//pionul este pozitionat pe linia 2 sau 7 in functie de culoare
			this.linie = 2;
		} else
			this.linie = 7;
	}
	
	public Pion() {									//va fi folosit la instantierea unei piese pentru verificarea cu introducere din consola a unei mutari  !!!CLASA PiesaSah NU POATE SA INSTANTIEZE OBIECTE!!!
													// => am nevoie de o piesa e care sa o instantiez
	}

	public int mutaPiesa(int lin_noua, char col_noua, TablaSah sah) {
	
		if ( col_noua > 'h' || col_noua < 'a' || lin_noua > 8 || lin_noua <1)		//daca se introduce o linie sau o coloana care iese din dimensiunea tablei de sah
			return 0;
		
		if (col_noua == coloana && lin_noua == linie)								//daca se dau aceleasi coordonate ca si cele curente, adica daca nu are loc o mutare
			return 0;
		
		if (sah.tabla[lin_noua][col_noua - 'a' + 1] != null && sah.tabla[lin_noua][col_noua - 'a' + 1].culoare == this.culoare)	//daca se incearca o mutare care ar captura o piesa proprie (de aceeasi culoare)
			return 0;																
		
		if (culoare == "alb" && sah.tabla[lin_noua][col_noua - 'a' + 1] == sah.k)	
			return 0;
																					//daca as captura regele oponentului
		if (culoare == "negru" && sah.tabla[lin_noua][col_noua - 'a' + 1] == sah.K)
			return 0;
		
		if (col_noua == coloana && lin_noua != linie) {								//daca pionul isi pastreaza coloana
			if(culoare == "alb") {													//pionii de culoare alba se deplaseaza pe linii de la 1 la 8 (pionul nu poate muta inapoi)
				if(linie == 2) {													//daca se afla inca pe linia 2 (in pozitia de start), pionul poate muta una sau doua patrate in fata
					if(lin_noua - linie == 1) {										
						if(sah.tabla[lin_noua][col_noua - 'a' + 1] == null){			//locul unde pionul se vrea a fi mutat trebuie sa fie liber, fiindca pionul nu poate efectua captura cand se deplaseaza pe aceeasi coloana
							sah.tabla[linie][coloana - 'a' + 1] = null;					//locul de unde a plecat pionul devine gol
							sah.tabla[lin_noua][col_noua - 'a' + 1] = this;				//mut pionul la pozitia noua
							linie = lin_noua;											//ii actualizez coordonatele
							coloana = col_noua;
							return 1;
						}
						return 0;
					}
					if(lin_noua - linie == 2) {																						//daca pionul se deplaseaza doua patrate in fata
						if(sah.tabla[lin_noua][col_noua - 'a' + 1] == null && sah.tabla[lin_noua][col_noua - 'a' + 1] == null){		//ambele patrate trebuie sa fie libere pentru a avea o mutare valida (pionul trebuie sa aiba "cale libera")
							sah.tabla[linie][coloana - 'a' + 1] = null;
							sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
							linie = lin_noua;
							coloana = col_noua;
							return 1;
						}
						return 0;
					}
					return 0;
				}
				else {																//daca pionul nu se afla in pozitia de inceput
					if(lin_noua - linie == 1) {										//el poate muta doar cate un patrat in fata
						if(sah.tabla[lin_noua][col_noua - 'a' + 1] == null) {
							sah.tabla[linie][coloana - 'a' + 1] = null;
							sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
							linie = lin_noua;
							coloana = col_noua;
							return 1;
						}
						return 0;
						}
					}
			}
			
			if(culoare == "negru") {												//algoritmul este analog pentru pionii de culoare neagra
				if(linie == 7) {													//cu mentiunea ca acestia se afla initial pe linia 7
					if(linie - lin_noua == 1) {										//si avanseaza inspre linii mai mici pe tabla de sah
						if(sah.tabla[lin_noua][col_noua - 'a' + 1] == null){
							sah.tabla[linie][coloana - 'a' + 1] = null;
							sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
							linie = lin_noua;
							coloana = col_noua;
							return 1;
						}
						return 0;
					}
					if(linie - lin_noua == 2) {
						if(sah.tabla[lin_noua][col_noua - 'a' + 1] == null && sah.tabla[lin_noua][col_noua - 'a' + 1] == null){
							sah.tabla[linie][coloana - 'a' + 1] = null;
							sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
							linie = lin_noua;
							coloana = col_noua;
							return 1;
						}
						return 0;
					}
					return 0;
				}
				else {
					if(linie - lin_noua == 1) {
						if(sah.tabla[lin_noua][col_noua - 'a' + 1] == null){
							sah.tabla[linie][coloana - 'a' + 1] = null;
							sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
							linie = lin_noua;
							coloana = col_noua;
							return 1;
						}
						return 0;
					}
				}
			}
		
			return 0;
		}
		
		if(col_noua != coloana && lin_noua == linie)									//pionul nu se poate deplasa orizontal (pe aceeasi linie)
			return 0;
		
		if(col_noua != coloana && lin_noua != linie) {									//daca pionul isi schimba ambele coordonate, el trebuie sa captureze o piesa adversa
			
			if(culoare == "alb") {
				if(lin_noua - linie == 1 && Math.abs(col_noua - coloana) == 1) {
					if(sah.tabla[lin_noua][col_noua - 'a' + 1] != null && sah.tabla[lin_noua][col_noua - 'a' + 1].culoare == "negru"){		//la noile coordonate trebuie sa existe o piesa de culoare diferita
						sah.tabla[linie][coloana - 'a' + 1] = null;
						sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
						linie = lin_noua;
						coloana = col_noua;
						return 1;
					}
					return 0;
				}
				return 0;
			}
			
			if(culoare == "negru") {
				if(linie - lin_noua == 1 && Math.abs(col_noua - coloana) == 1) {
					if(sah.tabla[lin_noua][col_noua - 'a' + 1] != null && sah.tabla[lin_noua][col_noua - 'a' + 1].culoare == "alb"){
						sah.tabla[linie][coloana - 'a' + 1] = null;
						sah.tabla[lin_noua][col_noua - 'a' + 1] = this;
						linie = lin_noua;
						coloana = col_noua;
						return 1;
					}
					return 0;
				}
				return 0;
			}
			
			return 0;
			
		}
		
		return 0;
	
	}
}
