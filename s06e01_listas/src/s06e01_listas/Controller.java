package s06e01_listas;

import java.util.ArrayList;
import java.util.Arrays;

class Amigo{
	private String nome;
	private int idade;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Amigo(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	public Amigo() {
		this.nome = "";
		this.idade = 0;
	}	
	@Override
	public String toString() {
		return "[" + this.nome + ", " + this.idade + "]";
	}
}

public class Controller {
	public static void main(String[] args) {
		ArrayList<Amigo> amigos = new ArrayList<Amigo>(Arrays.asList(new Amigo("Coringa", 45), new Amigo("Batman", 30)));		
		Amigo lex = new Amigo("Lex Luthor", 40);
		amigos.add(0, lex);
		System.out.println(amigos);
		
		amigos.set(0, new Amigo("Thanos", 10000));		
		amigos.remove(2);
		System.out.println(amigos);
		amigos.add(lex);
		Amigo vader = new Amigo("Darth Vader", 55);
		amigos.add(0, vader);
		amigos.add(0, vader);
		amigos.remove(lex);
		for(Amigo amigo : amigos) {
			if(amigo.getNome().equals("Coringa")) {
				amigos.remove(amigo);
				break;
			}
		}
		amigos.get(0).setIdade(56);
		System.out.println(amigos);
		
	}
}
