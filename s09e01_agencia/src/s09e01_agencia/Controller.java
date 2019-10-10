package s09e01_agencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Cliente{
	String id;
}

abstract class Conta{
	double saldo;
	int id;
	Cliente cliente;
	
	abstract String getTipo();
	abstract void update();
	@Override
	public String toString() {
		return this.id + ":" + this.cliente.id + ":" + this.saldo + ":" + this.getTipo();
	}
}

class ContaCorrente extends Conta{

	@Override
	String getTipo() {
		return "CC";
	}

	@Override
	void update() {
		this.saldo -= 20;
	}
}

class Agencia{
	List<Conta> contas;
	List<Cliente> clientes;
	
	Agencia(){
		this.contas = new ArrayList<Conta>();
		this.clientes = new ArrayList<Cliente>();
		this.nextId = 0;
	}
	
	boolean addCliente(String idCliente) {
		percorra a lista procurando esse cliente
		se achou
			retorne false
		Cliente cliente = new Cliente(idCliente)
		Conta cc = new ContaCorrente(nextid, cliente)
		nextid++
		Conta cp = new ContaPoupanca(nextId, cliente)
		nextid++
		cliente.addConta(cc)
		cliente.addConta(cp)
		this.contas.add(cc)
		this.contsa.add(cp)
		this.clientes.add(cliente)
	}
}

public class Controller {

}
