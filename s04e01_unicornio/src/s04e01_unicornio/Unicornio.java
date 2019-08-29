package s04e01_unicornio;

import java.util.Scanner;

public class Unicornio {
	int nPass;
	int maxPass;
	int carinhometro;
	int maxCarinhometro;
	
	void show() {
		
	}
	
	public static void main(String[] args) {
		Unicornio uni = new Unicornio();
		uni.maxPass = 2;
		uni.maxCarinhometro = 10;
		
		Scanner scanner = new Scanner(System.in);
		String line;
		while(true) {
			line = scanner.nextLine();
			String[] vet = line.split(" ");
			if(vet[0].equals("show")) {
				uni.show();
			}else {
				System.out.println("fail: comando invalido");
			}
		}
	}
}




