package s08e01_interfaces;

import java.util.ArrayList;

interface Passeavel{
	String levarPraPassear();
}

class Gato implements Passeavel{
	@Override
	public String levarPraPassear() {
		return "miando na bolsinha";
	}
}
class Soinnnn implements Passeavel{
	@Override
	public String levarPraPassear() {
		return "sentadinho no ombro";
	}
}

class VelhinhoTerminal implements Passeavel{
	@Override
	public String levarPraPassear() {
		return "Feliz vendo os bichinhos na cadeira de rodas";
	}
}

class Passeador{
	ArrayList<Passeavel> passeaveis;
	Passeador(){
		passeaveis = new ArrayList<Passeavel>();
	}
	void add(Passeavel pet) {
		passeaveis.add(pet);
	}
	void sairParaPassear() {
		for(Passeavel p : passeaveis)
			System.out.println(p.levarPraPassear());
	}
}

public class Controller {
	public static void main(String[] args) {
		Passeador jose = new Passeador();
		jose.add(new Soinnnn());
		jose.add(new Gato());
		jose.add(new VelhinhoTerminal());
		jose.add(new Passeavel() {
			public String levarPraPassear() {
				return "glu glu glu glu glu";
			}
		});
		jose.sairParaPassear();
	}
}







