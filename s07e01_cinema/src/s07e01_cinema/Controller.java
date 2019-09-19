package s07e01_cinema;

import java.util.ArrayList;

class Cliente{
	private String id;
	private String fone;
	
	public Cliente() {
		super();
	}

	public Cliente(String id, String fone) {
		super();
		this.id = id;
		this.fone = fone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	@Override
	public String toString() {
		return "" + this.id + ":" + this.fone;
	}
}

class Sala{
	ArrayList<Cliente> cadeiras;
	int capacidade;
	public Sala(int capacidade) {
		cadeiras = new ArrayList<Cliente>();
		for(int i = 0; i < capacidade; i++)
			cadeiras.add(null);
		this.capacidade = capacidade;
	}
	public void adicionar(int pos, Cliente cliente) {
		if(pos >= capacidade || pos < 0) {
			System.out.println("Posição invalida");
			return;
		}
		if(cadeiras.get(pos) != null) {
			System.out.println("Cadeira ocupada");
			return;
		}
		for(Cliente other : cadeiras) {
			if(other != null && other.getId().equals(cliente.getId())) {
				System.out.println("Você já está no cinema seu enrolão");
				return;
			}
		}
		cadeiras.set(pos, cliente);
	}
	public void remover(int pos) {
		cadeiras.set(pos, null);
	}
	public void removerNome(String nome) {
		for(int i = 0; i < this.cadeiras.size(); i++) {
			Cliente cliente = this.cadeiras.get(i);
			if(cliente != null && cliente.getId().contentEquals(nome)) {
				this.cadeiras.set(i, null);
			}
		}
	}
	
	@Override
	public String toString() {
		String out = "[ ";
		for(Cliente cliente : this.cadeiras) {
			if(cliente != null)
				out += cliente + " ";
			else
				out += "- ";
		}
		out += "]";
		return out;
	}
}
public class Controller {
	public static void main(String[] args) {
		Sala sala = new Sala(5);
		sala.adicionar(0, new Cliente("davi", "5555"));
		sala.adicionar(1, new Cliente("davi", "5555"));
		sala.adicionar(2, new Cliente("davi", "5555"));
		sala.adicionar(3, new Cliente("davi", "5555"));
		sala.adicionar(4, new Cliente("davi", "5555"));
		System.out.println(sala);
	}
}










