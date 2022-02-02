//Clasa abstracta PiesaSah contine atributele si metodele care corespund oricarei subclase ce defineste un tip specific de piesa (Rege, Pion, Nebun etc.)
//Fiecare piesa are:
		//un nume (un tip de piesa)
		//linia si coloana pe care se gasesc pe tabla, coloana fiiind exprimata drept un caracter de la 'a' la 'h'
		//o culoare (alb sau negru)
//Metoda abstracta mutaPiesa este specifica fiecarui tip de piesa, si va fi implementata ca atare in fiecare subclasa

package lab5;

public abstract class PiesaSah {
	String numePiesa;
	int linie;
	char coloana;
	String culoare;
	
	PiesaSah(){
		
	}
	
	abstract int mutaPiesa(int lin_noua, char col_noua, TablaSah sah);
}
