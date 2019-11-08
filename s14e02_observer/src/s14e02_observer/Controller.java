package s14e02_observer;

public class Controller{
	public static void main(String[] args) {
		Repository<Integer, String> numeros = new Repository<Integer, String>("numero");
		Historico<String> historico = new Historico<>(numeros);
		numeros.add(5, "cinco");
		numeros.add(6, "seis");
		numeros.add(7, "sete");
		System.out.println(historico);
	}
}

