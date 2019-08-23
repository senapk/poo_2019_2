package arquivos;
/*

 */
public class Ventilador {
	boolean estaLigado;
	int velocidade;
	boolean estaGirando;
	
	
	void ligar () {
		if(!estaLigado) {
			System.out.println("Ligando o ventilador");
			estaLigado = true;
		}
	}
	/*
	void desligar ()
	void girar ()
	void pararDeGirar ()
	void aumentarVelocidade ()
	void diminuirVelocidade ()
	*/
	void showStatus() {
		System.out.println("Ligado: " + estaLigado + 
						   ", vel: " + 	velocidade + 
						   ", girando: " + estaGirando);
		System.out.println("Esta ventilando");
	}
	public static void main(String[] args) {
		Ventilador arno = new Ventilador();
		arno.showStatus();
		arno.ligar();
		arno.ligar();
		arno.ligar();
		arno.ligar();
		arno.ligar();
		arno.ligar();
		
	}
}







