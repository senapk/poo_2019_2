package poo;


class Moto{
	int qtdPass;
	boolean estaLigada;
	
	void ligar() {
		if(qtdPass == 0) {
			System.out.println("Nao ha ninguem na moto");
			return;
		}
		if(estaLigada) {
			System.out.println("Ja esta ligada!!");
			return;
		}

		estaLigada = true;
		System.out.println("Ligando a moto");
	}
	void desligar() {
		if(qtdPass == 0) {
			System.out.println("Nao ha ninguem na moto");
			return;
		}
		if(!estaLigada) {
			System.out.println("Ja esta desligada!!");
			return;
		}
		estaLigada = false;
		System.out.println("Desligando a moto");
	}
	//dirigir
	void montar() {
		if(qtdPass < 2) {
			qtdPass += 1;
			System.out.println("Subindo na moto");
		}else {
			System.out.println("Moto lotada");
		}
	}
	void desmontar() {
		if(qtdPass > 0) {
			qtdPass -= 1;
			System.out.println("Descendo da moto");
		}else {
			System.out.println("Moto vazia");
		}
		
	}
}

public class Controller 
{

	public static void main(String[] args) {
		Moto moto1 = new Moto();
		moto1.estaLigada = false;
		moto1.qtdPass = 0;
		moto1.montar();
		moto1.ligar();
		moto1.desmontar();
		moto1.desligar();
		moto1.desmontar();
	}

}









