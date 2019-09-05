package s05e01_acesso;

class Pessoa{
	String nome;
	static String especie = "Homo sapiens";
	public Pessoa(String nome) {
		this.nome = nome;
	}
}

class Conta{
	static int nextId = 0;
	int id;
	
	public Conta(){
		this.id = nextId;
		nextId += 1;
	}
	
}


public class ClasseDois {
	public static void main(String[] args) {
		Conta um = new Conta();
		Conta dois = new Conta();
		Conta tres = new Conta();
	}
}
