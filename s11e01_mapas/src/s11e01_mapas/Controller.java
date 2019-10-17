package s11e01_mapas;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Cliente{
	String id;
	int num;
	public Cliente(String id, int num) {
		super();
		this.id = id;
		this.num = num;
	}
}


public class Controller {
	public static void main(String[] args) {
		
		Map<String, Cliente> clientes = new TreeMap<String, Cliente>();
		clientes.put("Davi", new Cliente("Davi", 234));
		clientes.put("Levi", new Cliente("Levi", 134));
		clientes.put("Ravi", new Cliente("Ravi", 334));
		clientes.put("Cuvi", new Cliente("Cuvi", 434));
		
		
		Cliente cli = clientes.get("Davi");
		if(cli != null)
			System.out.println("Cliente" + cli.id);
		else
			System.out.println("Cliente nao existe");
		
		for(String key : clientes.keySet()) {
			System.out.println(clientes.get(key).id);
		}
		
		Cliente davi = clientes.remove("Ravier");
		for(String key : clientes.keySet()) {
			System.out.println(clientes.get(key).id);
		}		
		System.out.println("Removi o " + davi.id);
	}

}











