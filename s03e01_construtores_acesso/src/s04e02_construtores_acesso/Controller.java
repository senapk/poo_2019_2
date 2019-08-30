package s04e02_construtores_acesso;

public class Controller {
	public static void main(String[] args) {
		
		Motor motor = new Motor();
		motor.potencia = 300;
		Carro carro = new Carro("Herbie", 2, null);
		carro.acelerar();
		carro.setMotor(motor);
		carro.acelerar();
	}
}
