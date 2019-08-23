package s03e02_input;

import java.util.Scanner;

class Peixe{
	int barriga = 0;
	int maxBarriga = 5;
	boolean isAlive = true;
	void alimentar(int qtd){ //aumenta a quantidade de comida na barriga até o máximo
		if(isAlive) {
			barriga += qtd;
			System.out.println("Nhami nhami");
			if(barriga > maxBarriga) {
				System.out.println("explodiu");
				isAlive = false;
			}
				
		}
	}
	void esperar() { //diminui a quantidade de comida, 1 por vez, ate zero
		if(isAlive) {
			barriga -= 1;
			System.out.println("Affffffffff");
			if(barriga < 0) {
				System.out.println("Definou");
				isAlive = false;
			}
		}
	}
	void status() {
		if(isAlive)
			System.out.print("Vivo");
		else
			System.out.print("Morto");
		System.out.println(" com a barriga: " + barriga);
	}
}
public class Controller {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Peixe marlin = new Peixe();
		marlin.maxBarriga = 10;
		System.out.println("feed; wait; show");
		while(true) {
			String line = scanner.nextLine();
			String[] vet = line.split(" ");
			
			if(vet[0].equals("feed"))
				marlin.alimentar(Integer.parseInt(vet[1]));
			else if(vet[0].equals("wait"))
				marlin.esperar();
			else if(vet[0].equals("show"))
				marlin.status();
			else if(vet[0].equals("end"))
				break;
			else
				System.out.println("fail: comando invalido");
		}
	}
}








