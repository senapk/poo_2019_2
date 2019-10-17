package s10e02_debugs;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();
		while(true) {
			String line = scanner.nextLine();
			String[] ui = line.split(" ");
			if(ui[0].contentEquals("addCli")) {
				clientes.add(new Cliente(ui[1]));
			}
		}
	}
}
