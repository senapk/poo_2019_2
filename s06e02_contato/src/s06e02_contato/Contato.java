package s06e02_contato;

import java.util.ArrayList;

class Fone{
	private String num;
	private String id;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Fone(String num, String id) {
		super();
		this.num = num;
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.id + ":" + this.num + "]";
	}
}

public class Contato{
	private String nome;
	private ArrayList<Fone> fones;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Fone> getFones() {
		return fones;
	}
	public Contato(String nome) {
		super();
		this.nome = nome;
		this.fones = new ArrayList<Fone>(); //composicao
	}
	public void addFone(String id, String fone) {
		this.fones.add(new Fone(fone, id));
	}
	public void rmFone(int index) {
		this.fones.remove(index);
	}
	@Override
	public String toString() {
		return this.nome + ":" + this.getFones();
	}
	
	public static void main(String[] args) {
		Contato david = new Contato("David");
		david.addFone("casa", "32323232");
		david.addFone("trab", "33333333");
		david.addFone("reca", "44444444");
		david.rmFone(1);
		System.out.println(david);
	}
}











