package lab5;

public class TablaSah {
	
	public PiesaSah[][] tabla = new PiesaSah[10][10];
	
	Rege   K = new Rege("alb");
	Regina Q = new Regina("alb");
	Nebun B1 = new Nebun("alb", 'c');
	Nebun B2 = new Nebun("alb", 'f');
	Cal   N1 = new Cal("alb", 'b');
	Cal   N2 = new Cal("alb", 'g');
	Turn  R1 = new Turn("alb", 'a');
	Turn  R2 = new Turn("alb", 'h');
	
	Pion  P1 = new Pion("alb", 'a');
	Pion  P2 = new Pion("alb", 'b');
	Pion  P3 = new Pion("alb", 'c');
	Pion  P4 = new Pion("alb", 'd');
	Pion  P5 = new Pion("alb", 'e');
	Pion  P6 = new Pion("alb", 'f');
	Pion  P7 = new Pion("alb", 'g');
	Pion  P8 = new Pion("alb", 'h');
	
	
	Rege   k = new Rege("negru");
	Regina q = new Regina("negru");
	Nebun b1 = new Nebun("negru", 'c');
	Nebun b2 = new Nebun("negru", 'f');
	Cal   n1 = new Cal("negru", 'b');
	Cal   n2 = new Cal("negru", 'g');
	Turn  r1 = new Turn("negru", 'a');
	Turn  r2 = new Turn("negru", 'h');
	
	Pion  p1 = new Pion("negru", 'a');
	Pion  p2 = new Pion("negru", 'b');
	Pion  p3 = new Pion("negru", 'c');
	Pion  p4 = new Pion("negru", 'd');
	Pion  p5 = new Pion("negru", 'e');
	Pion  p6 = new Pion("negru", 'f');
	Pion  p7 = new Pion("negru", 'g');
	Pion  p8 = new Pion("negru", 'h');
	
	public TablaSah() {
		this.tabla[1][1] = R1;
		this.tabla[1][2] = N1;
		this.tabla[1][3] = B1;
		this.tabla[1][4] = Q;
		this.tabla[1][5] = K;
		this.tabla[1][6] = B2;
		this.tabla[1][7] = N2;
		this.tabla[1][8] = R2;
		
		this.tabla[2][1] = P1;
		this.tabla[2][2] = P2;
		this.tabla[2][3] = P3;
		this.tabla[2][4] = P4;
		this.tabla[2][5] = P5;
		this.tabla[2][6] = P6;
		this.tabla[2][7] = P7;
		this.tabla[2][8] = P8;
		
		this.tabla[8][1] = r1;
		this.tabla[8][2] = n1;
		this.tabla[8][3] = b1;
		this.tabla[8][4] = q;
		this.tabla[8][5] = k;
		this.tabla[8][6] = b2;
		this.tabla[8][7] = n2;
		this.tabla[8][8] = r2;
		
		this.tabla[7][1] = p1;
		this.tabla[7][2] = p2;
		this.tabla[7][3] = p3;
		this.tabla[7][4] = p4;
		this.tabla[7][5] = p5;
		this.tabla[7][6] = p6;
		this.tabla[7][7] = p7;
		this.tabla[7][8] = p8;
	}
}
