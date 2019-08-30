package s04e02_construtores_acesso;

public class Carro {
	int nPass;
	int nMaxPass;
	String nome;
	Motor motor;

	//composicao -> o carro cria o motor
	//agregacao -> o carro recebe o motor
	public Carro(String nome, int nMaxPass) {
		this.nome = nome;
		this.nMaxPass = nMaxPass;
		this.nPass = 0;
	}
	
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public void embarcar(int qtd) {
		if(this.nPass + qtd <= this.nMaxPass)
			this.nPass += qtd;
		else
			System.out.println("fail: nao cabe");
	}
	
	public void acelerar(int forca) {
		if(nPass == 0) {
			System.out.println("fail: Ninguem no carro");
			return;
		}
			
		if(motor != null) {
			System.out.println(this.nome + ": Vrummm com " + motor.potencia + " cavalos");
			if(forca > motor.potencia)
				motor = null;
		}else
			System.out.println("Cueeennnnn");
		
	}
}
