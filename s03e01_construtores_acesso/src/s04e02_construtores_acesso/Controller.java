package s04e02_construtores_acesso;

import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line;
		Carro carro = new Carro();
		while(true) {
			line = scanner.nextLine();
			String vet[] = line.split(" ");
			if(vet[0].equals("init")) {//qtdMaxpass
				carro = new Carro(vet[1], Integer.parseInt(vet[2]));
			}else if(vet[0].equals("setMotor")){//potencia
				carro.setMotor(new Motor(Integer.parseInt(vet[1])));
			}else if(vet[0].equals("acelerar")){
				carro.acelerar(Integer.parseInt(vet[1]));
			}else if(vet[0].equals("embarcar")) {
				carro.embarcar(Integer.parseInt(vet[1]));
			}
		}
	}
}
