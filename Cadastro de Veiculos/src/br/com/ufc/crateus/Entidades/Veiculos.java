package br.com.ufc.crateus.Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Veiculos {
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	private Scanner input;
	
	public void adicionaVeiculo() {
		String placa;
		String marca;
		String modelo;
		String fabricante;
		int ano;
		input = new Scanner(System.in);
		//-----------------------------------------------------------------------
		System.out.println("\nDigite a Placa do veiculo: ");
		placa = input.nextLine();
		System.out.println("\nDigite a Marca do veiculo: ");
		marca = input.nextLine();
		System.out.println("\nDigite o Modelo do veiculo: ");
		modelo = input.nextLine();
		System.out.println("\nDigite o Fabricante do veiculo: ");
		fabricante = input.nextLine();
		System.out.println("\nDigite o Ano do veiculo: ");
		ano = input.nextInt();
		Veiculo veiculo = new Veiculo(placa, marca, modelo, fabricante, ano);
		veiculos.add(veiculo);
		//-----------------------------------------------------------------------
		String newLine = System.getProperty("line.separator");
		try {
			File arquivo = new File("CadastroVeiculos.txt"); //Cria Arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw); // Escreve no arquivo
			
			bw.write(veiculo.toString() + newLine);
			bw.flush();
			bw.close();
			System.out.println("Veiculo adicionado com sucesso!");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void removeVeiculo() {
		String placa;
		String marca;
		String modelo;
		String fabricante;
		int ano;
		input = new Scanner(System.in);
		//-----------------------------------------------------------------------
		System.out.println("\nDigite a placa do veiculo que deseja remover: ");
		placa = input.nextLine();
		System.out.println("\nDigite a Marca do veiculo que deseja remover: ");
		marca = input.nextLine();
		System.out.println("\nDigite o Modelo do veiculo que deseja remover: ");
		modelo = input.nextLine();
		System.out.println("\nDigite o Fabricante do veiculo que deseja remover: ");
		fabricante = input.nextLine();
		System.out.println("\nDigite o Ano do veiculo que deseja remover: ");
		ano = input.nextInt();
		Veiculo veiculo = new Veiculo(placa, marca, modelo, fabricante, ano);
		this.veiculos.remove(veiculo);
		//-----------------------------------------------------------------------
		try{
			ArrayList<String> aux = new ArrayList<>(); //VETOR AUXILIAR PARA SALVAR AS LINHAS DO ARQUIVO (MENOS A QUE SERÁ EXCLUIDA)
			FileReader arq = new FileReader("CadastroVeiculos.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			
			while(linha != null) {
				if(linha.equals(veiculo.toString()) == false) {
					aux.add(linha);	//SALVA TODAS AS LINHAS MENOS A DO VEICULO QUE SERÁ EXCLUIDO.
				}
				linha = lerArq.readLine();
			}
			
			arq.close();
			lerArq.close();
			FileWriter fw2 = new FileWriter("CadastroVeiculos.txt", true);
			fw2.close();
			
			FileWriter fw = new FileWriter("CadastroVeiculos.txt");
			BufferedWriter bw = new BufferedWriter(fw); // Escreve no arquivo
			
			for(int i = 0; i < aux.size(); i++) {
				bw.write(aux.get(i));
				bw.newLine();
			}
			bw.close();
			fw.close();
			
		}catch (Exception e) {
			e.printStackTrace();			
		}
	}
	
	public void mostraVeiculosCadastrados() throws IOException {
		System.out.println("Lista de Veiculos: \n");
		ArrayList<String> linhas = new ArrayList<String>();
		FileReader arq = new FileReader("CadastroVeiculos.txt");
		BufferedReader lerArq = new BufferedReader(arq);
		String linha = lerArq.readLine();
		linhas.add(linha);

        while (linha != null) {
            linha = lerArq.readLine();
            linhas.add(linha);
        }
        arq.close();
        linhas.remove(linhas.size() - 1);
        
		for(String veiculo : linhas) {
			System.out.println(veiculo);
		}
	}
	
	public void buscaPorPlaca() {
		input = new Scanner(System.in);
		System.out.println("Digite a placa do veiculo que deseja procurar: ");
		String placa = input.nextLine();
		//---------------------------------------------------------------------------
		try {
			FileReader arq = new FileReader("CadastroVeiculos.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			
			while(linha != null) {
				for(Veiculo veiculo : veiculos) {
					if(veiculo.getPlaca().equals(placa)) {
						System.out.println(veiculo.toString());
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void buscaPorFabricante() {
		System.out.println("Digite a placa do veiculo que deseja procurar: ");
		input = new Scanner(System.in);
		String fabricante = input.nextLine();
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getFabricante().equals(fabricante)) {
				System.out.println(veiculo.toString());
			}
		}
	}
	
	public void buscaPorModelo() {
		System.out.println("Digite a placa do veiculo que deseja procurar: ");
		input = new Scanner(System.in);
		String modelo = input.nextLine();
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getModelo().equals(modelo)) {
				System.out.println(veiculo.toString());
			}
		}
	}
	
	public void buscaPorAno() {
		System.out.println("Digite a placa do veiculo que deseja procurar: ");
		input = new Scanner(System.in);
		int ano = input.nextInt();
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getAno() == ano) {
				System.out.println(veiculo.toString());
			}
		}
	}

	public void buscaPorMarca() {
		System.out.println("Digite a placa do veiculo que deseja procurar: ");
		input = new Scanner(System.in);
		String marca = input.nextLine();
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getMarca().equals(marca)) {
				System.out.println(veiculo.toString());
			}
		}
	}
}
