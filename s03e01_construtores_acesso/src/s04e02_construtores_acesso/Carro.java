package s04e02_construtores_acesso;

public class Carro {
	int nPass;
	String nome;
	Motor motor;

	//composicao -> o carro cria o motor
	//agregacao -> o carro recebe o motor
	public Carro(String nome, int nPass, Motor motor) {
		this.nome = nome;
		this.nPass = nPass;
	}
	
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public void acelerar() {
		if(motor != null)
			System.out.println(this.nome + ": Vrummm com " + motor.potencia + " cavalos");
		else
			System.out.println("Cueeennnnn");
	}
}
