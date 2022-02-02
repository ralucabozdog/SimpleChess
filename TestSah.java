package lab5;

import java.util.Scanner;

public class TestSah {															//clasa din care se executa codul

	public static void afisListaPiese(TablaSah sah) {							//metoda pentru afisarea tuturor pieselor, cu coordonatele lor curente
		
		for(int i = 1; i <= 8; i++) {
			for(char j = 'a'; j <= 'h'; j++) {
				if(sah.tabla[i][j - 'a' + 1] != null) {
					System.out.println(sah.tabla[i][j - 'a' + 1].numePiesa + " " + sah.tabla[i][j - 'a' + 1].culoare + " : linia " + (i) + " " + " coloana " + (j));
				}
			}
		}
	}
	
public static void afisPieseTabla(TablaSah sah) {								//metoda pentru afisarea tablei de sah cu toate piesele la coordonatele lor actuale
		
	char[][] matr = new char[10][10];											//matrice de caractere care va afisa codificarea literala a pieselor
	
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				if(sah.tabla[i][j] != null) {									//daca exista o piesa la coordonatele i si j
					if(sah.tabla[i][j].culoare == "alb") {						//piesele de culoare alba vor f codificate cu majuscule
						if(sah.tabla[i][j].numePiesa == "Pion")
							matr[i][j] = 'P';									//P pentru Pion   (pawn)
						if(sah.tabla[i][j].numePiesa == "Cal")
							matr[i][j] = 'N';									//N pentru Cal    (knight)
						if(sah.tabla[i][j].numePiesa == "Nebun")
							matr[i][j] = 'B';									//B pentru Nebun  (bishop)
						if(sah.tabla[i][j].numePiesa == "Rege")
							matr[i][j] = 'K';									//K pentru Rege   (king)
						if(sah.tabla[i][j].numePiesa == "Regina")
							matr[i][j] = 'Q';									//Q pentru Regina (queen)
						if(sah.tabla[i][j].numePiesa == "Turn")
							matr[i][j] = 'R';									//R pentru Turn   (rook)
					}
					else {														//piesele de culoare nearga vor fi codificate cu litere mici
						if(sah.tabla[i][j].numePiesa == "Pion")
							matr[i][j] = 'p';									//p pentru Pion   (pawn)
						if(sah.tabla[i][j].numePiesa == "Cal")
							matr[i][j] = 'n';									//n pentru Cal    (knight)
						if(sah.tabla[i][j].numePiesa == "Nebun")
							matr[i][j] = 'b';									//b pentru Nebun  (bishop)
						if(sah.tabla[i][j].numePiesa == "Rege")
							matr[i][j] = 'k';									//k pentru Rege   (king)
						if(sah.tabla[i][j].numePiesa == "Regina")
							matr[i][j] = 'q';									//q pentru Regina (queen)
						if(sah.tabla[i][j].numePiesa == "Turn")
							matr[i][j] = 'r';									//r pentru Turn   (rook)
					}
				}
				else
					matr[i][j] = '*';											//locurile libere de pe tabla de sah vor fi codificate cu *
			}
		}
		
		for(int i = 8; i >= 1; i--) {											//liniile se afiseaza de la ultima inspre prima pentru a avea piesele de culoare alba in partea de jos a tablei
			System.out.print(i + "   ");
			for(int j = 1; j<=8; j++) {
				System.out.print(matr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("    a b c d e f g h");
		System.out.println();
	}
	
	public static void dupaMutare(int valid, TablaSah sah) {				//metoda pentru a comunica daca mutarea dorita este sau nu valida
		if(valid == 0) {
			System.out.println();
			System.out.println("Mutare invalida");							//daca mutarea este invalida, se comunica acest lucru printr-un mesaj
		}
		else {																//daca mutarea este valida, se afiseaza mesaj si se afiseaza tabla cu noua configuratie
			System.out.println();
			System.out.println("Mutare valida:");
			afisPieseTabla(sah);
		}
	}
	

public static void main(String[] args) {
		
		TablaSah sah = new TablaSah();
		
		afisPieseTabla(sah);
		
		/*dupaMutare(sah.P4.mutaPiesa(4, 'd', sah), sah);
		dupaMutare(sah.p3.mutaPiesa(5, 'c', sah), sah);
		dupaMutare(sah.P4.mutaPiesa(5, 'c', sah), sah);
		dupaMutare(sah.P4.mutaPiesa(6, 'c', sah), sah);
		dupaMutare(sah.P4.mutaPiesa(7, 'd', sah), sah);
		dupaMutare(sah.P4.mutaPiesa(8, 'e', sah), sah);*/
		
		/*dupaMutare(sah.P1.mutaPiesa(4, 'a', sah), sah);
		dupaMutare(sah.p2.mutaPiesa(5, 'b', sah), sah);
		dupaMutare(sah.P1.mutaPiesa(5, 'b', sah), sah);
		dupaMutare(sah.R1.mutaPiesa(7, 'a', sah), sah);
		dupaMutare(sah.R1.mutaPiesa(7, 'c', sah), sah);
		dupaMutare(sah.R1.mutaPiesa(8, 'c', sah), sah);
		dupaMutare(sah.R1.mutaPiesa(8, 'b', sah), sah);
		dupaMutare(sah.r1.mutaPiesa(8, 'b', sah), sah);
		dupaMutare(sah.r1.mutaPiesa(5, 'b', sah), sah);*/
		
		/*dupaMutare(sah.N1.mutaPiesa(3, 'c', sah), sah);
		dupaMutare(sah.n2.mutaPiesa(6, 'f', sah), sah);
		dupaMutare(sah.N1.mutaPiesa(5, 'd', sah), sah);
		dupaMutare(sah.n2.mutaPiesa(5, 'd', sah), sah);*/
		
		int lin_noua;
		char col_noua;
		int lin_curenta;
		char col_curenta;
		
		Scanner in = new Scanner(System.in);									//declar un nou obiect de tip scanner
		
		for(int i = 1; i <= 10000; i++) {										//consider ca pot face 10000 de mutari
			
			System.out.println();
			
			System.out.println("Coordonatele actuale ale piesei: ");			//citesc din consola coordonatele actuale ale piesei
			
			System.out.println("Linia: ");
			lin_curenta = in.nextInt();											//urmatorul intreg citit este lin_curenta
			
			System.out.println("Coloana: ");
			col_curenta = in.next().charAt(0);									//urmatorul caracter citit este col_curenta
			
																				//am nevoie de un obiect de clasa PiesaSah pe care sa il folosesc pentru a apela din el metoda mutaPiesa
			PiesaSah piesa = new Pion();										//dar PiesaSah este o clasa abstracta => nu poate fi instantiata (nu pot sa ii atribui direct un obiect); o consider de tip Pion
			piesa = sah.tabla[lin_curenta][col_curenta - 'a' + 1];				//piesa primeste caracteristicile ei reale de pe tabla de sah, de la coordonatele citite 
																				//asa aflu ce piesa am pe tabla de sah la coordonatele lin_noua si col_noua
			
			
			System.out.println();
			System.out.println("Mutare pe linia: ");							//citesc coordonatele la care vreau sa se faca mutarea
			
			lin_noua = in.nextInt();											//urmatorul intreg citit este lin_noua
			
			System.out.println("Mutare pe coloana: ");							
				
			col_noua = in.next().charAt(0);										//urmatorul char citit este col_noua
			
			dupaMutare(piesa.mutaPiesa(lin_noua, col_noua, sah), sah);			//apelez metoda "dupaMutare"; metoda "mutaPiesa" trebuie sa fie legata de un obiect, motiv pentru care folosesc obiectul declarat la linia 132
		}
		
		in.close();																//"inchid" consola		
		
	}
}
