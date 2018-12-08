package br.com.ufc.crateus.Entidades;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private String fabricante;
	private int ano;
	
	public Veiculo(String placa, String marca, String modelo, String fabricante, int ano) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.ano = ano;
	}
	
	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAno() {
		return ano;
	}
	
	@Override
	public String toString() {
		return placa + "|" +  marca + "|" +  modelo + "|" + 
				 fabricante + "|"  + ano;
	}
}
