package s03e02_input;

import java.util.Scanner;

class Peixe{
	int barriga = 0;
	int maxBarriga = 5;
	void alimentar(int qtd){ //aumenta a quantidade de comida na barriga até o máximo
		barriga += qtd;
		System.out.println("Nhami nhami");
	}
	void esperar() { //diminui a quantidade de comida, 1 por vez, ate zero
		barriga -= 1;
		System.out.println("Affffffffff");
	}
	void status() {
		System.out.println("Vivo com a barriga: " + barriga);
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
			
			if(vet[0].equals("feed")) {
				marlin.alimentar(Integer.parseInt(vet[1]));
			}
			else if(vet[0].equals("wait"))
				marlin.esperar();
			else if(vet[0].equals("show"))
				marlin.status();
			else if(vet[0].equals("end"))
				break;
		}
	}
}








