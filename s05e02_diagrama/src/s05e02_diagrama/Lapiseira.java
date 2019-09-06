package s05e02_diagrama;

public class Lapiseira {
	private double ponta;
	private String marca;
	private int tamanhoGrafite;
	
	public Lapiseira(double ponta, String marca) {
		super();
		this.ponta = ponta;
		this.marca = marca;
		this.tamanhoGrafite = 0;
	}
	
	public void escrever(int qtd) {
		if(this.tamanhoGrafite == 0) {
			System.out.println("fail: nao tem grafite");
			return;
		}
		this.tamanhoGrafite -= qtd;
		if(this.tamanhoGrafite < 0)
			this.tamanhoGrafite = 0;
		System.out.println("Escrevendo");
	}
	
	public void colocarGrafite(double ponta, int tamanho) {
		if(this.ponta == ponta) {
			this.tamanhoGrafite = tamanho;
		}else {
			System.out.println("fail: ponta incompativel");
		}
	}
		
	
	public double getPonta() {
		return ponta;
	}
	public void setPonta(double ponta) {
		this.ponta = ponta;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getTamanhoGrafite() {
		return tamanhoGrafite;
	}
	public void setTamanhoGrafite(int tamanhoGrafite) {
		this.tamanhoGrafite = tamanhoGrafite;
	}
	
	@Override
	public String toString() {
		return "marca:" + this.marca + ", ponta:" + this.ponta + ", gtam:" + this.tamanhoGrafite;
	}
	
	
	public static void main(String[] args) {
		Lapiseira pentel = new Lapiseira(0.7, "Pentel");
		pentel.escrever(4);
		pentel.colocarGrafite(0.7, 3);
		pentel.escrever(2);
		System.out.println(pentel);
	}
}












