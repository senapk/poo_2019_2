package s11e01_mapas;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Repositorio <Tranqueira>{
	Map<String, Tranqueira> dados;
	String nametype;
	
	public Repositorio(String nametype) {
		dados = new TreeMap<String, Tranqueira>();
		this.nametype = nametype;
	}
	
	public void add(String key, Tranqueira data) {
		Tranqueira t = dados.get(key);
		if(t == null)
			dados.put(key, data);
		else
			throw new RuntimeException(nametype + " " + key + " ja existe");
	}
	public Tranqueira get(String key) {
		Tranqueira t = dados.get(key);
		if(t == null)
			throw new RuntimeException(nametype + " " + key + " nao existe");
		return t;
	}
	public ArrayList<Tranqueira> getAll(){
		ArrayList<Tranqueira> out = new ArrayList<Tranqueira>();
		for(String key : dados.keySet())
			out.add(dados.get(key));
		return out;
	}
	
}

class Pet{
	String id;
	String raca;
	public Pet(String id, String raca) {
		super();
		this.id = id;
		this.raca = raca;
	}
	@Override
	public String toString() {
		return this.id + ":" + this.raca;
	}
}

class Dono{
	String id;
	Repositorio<Pet> pets;
	public Dono(String id) {
		this.id = id;
		this.pets = new Repositorio<Pet>("Pet");
	}
	@Override
	public String toString() {
		String out = id + "[ ";
		for(Pet pet : pets.getAll())
			out += pet + " ";
		return out + "]";
	}
}

class Servico{
	String id;
	float valor;
	public Servico(String id, float valor) {
		super();
		this.id = id;
		this.valor = valor;
	}
	
}

class Clinica{
	Repositorio<Servico> servicos;
	Repositorio<Dono> donos;
	public Clinica() {
		servicos = new Repositorio<Servico>("Servico");
		donos = new Repositorio<Dono>("Dono");
	}	
	@Override
	public String toString() {
		return "" + donos.getAll();
	}
}


public class Veterinario {
	
	public static void main(String[] args) {
		Clinica clinica = new Clinica();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				String line = scanner.nextLine();
				String ui[] = line.split(" ");
				if(ui[0].contentEquals("end"))
					break;
				else if(ui[0].equals("addDono")) {
					clinica.donos.add(ui[1], new Dono(ui[1]));
				}else if(ui[0].equals("addPet")) {//dono idPet raca
					clinica.donos.get(ui[1]).pets.add(ui[2], new Pet(ui[2], ui[3]));
				}else if(ui[0].equals("show")) {
					System.out.println(clinica);
				}else if(ui[0].equals("showDono")) {
					System.out.println(clinica.donos.get(ui[1]));
				}else {
					System.out.println("  fail:comando invalido");
				}
				
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
	}
}











