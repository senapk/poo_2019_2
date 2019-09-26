package s07e02_heranca;

import java.util.ArrayList;
import java.util.Collections;

abstract class Animal{
	abstract boolean getAlive();
}

class Gato extends Animal implements Comparable<Gato>{
	private String nome;
	protected int vidas;
	public Gato(String nome) {
		this.nome = nome;
		this.vidas = 7;
	}
	public String getMiado() {
		return "miau";
	}
	public String toString() {
		return this.nome + ":" + this.vidas + " vidas:" + getMiado();
	}
	@Override
	boolean getAlive() {
		return this.vidas > 0;
	}
	@Override
	public int compareTo(Gato o) {
		//return this.vidas - o.vidas;
		return this.nome.compareTo(o.nome);
	}
}

class GatoRusso extends Gato{
	boolean temCirrose;
	public GatoRusso(String nome) {
		super(nome + "ovisk");
		this.vidas = 70;
	}
	@Override
	public String getMiado() {
		return "miovisk";
	}
	@Override
	public String toString() {
		String out = super.toString();
		if(this.temCirrose)
			out += " com cirrose";
		return out;
	}
	public void beberVodka() {
		this.vidas -= 1;
		this.temCirrose = true;
		System.out.println("Glupovisk, Glupovisk");
	}
}

public class Controler {
	public static void main(String[] args) {
		ArrayList<Gato> saco = new ArrayList<Gato>();
		
		saco.add(new GatoRusso("furios"));
		saco.add(new Gato("bartolomeu"));
		saco.add(new Gato("chaninha"));
		saco.add(new GatoRusso("matad"));
		Collections.sort(saco);
		for(Gato gato : saco)
			System.out.println(gato);
		for(Gato gato : saco)
			System.out.println(gato.getMiado());
		for(Gato gato : saco) {
			if(gato instanceof GatoRusso) {
				((GatoRusso) gato).beberVodka();
			}
		}
		for(Gato gato : saco)
			System.out.println(gato);
	}
}
