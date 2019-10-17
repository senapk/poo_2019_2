package s10e02_debugs;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	String id;
	List<Conta> contas;
	public Cliente(String id) {
		this.id = id;
		this.contas = new ArrayList<Conta>();
	}
	public void addConta(Conta conta) {
		this.contas.add(conta);
	}
}
