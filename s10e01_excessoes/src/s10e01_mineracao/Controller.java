package s10e01_mineracao;

import java.util.Scanner;

class Calculadora{
	int battery;
	public Calculadora(int battery) {
		this.battery = battery;
	}
	float divide(int x, int y) {
		if(this.battery == 0)
			throw new RuntimeException("warning: sem bateria");
		if(y == 0)
			throw new RuntimeException("warning: divisao por 0");
		this.battery--;
		return (float)x / y;	
	}
}

public class Controller {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calculadora calc = new Calculadora(2);
		while(true) {
			try {
				System.out.println("Digite dois valores");	
				String line = scanner.nextLine();
				String ui[] = line.split(" ");
				int x = Integer.parseInt(ui[0]);
				int y = Integer.parseInt(ui[1]);
				System.out.println(calc.divide(x, y));
			}catch(NumberFormatException e) {
				System.out.println("Em digitos seu bocó");;
			}catch(RuntimeException excessao) {
				System.out.println(excessao.getMessage());
			}
		}		
	}
}
