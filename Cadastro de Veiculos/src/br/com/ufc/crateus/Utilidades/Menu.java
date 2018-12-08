package br.com.ufc.crateus.Utilidades;

import java.io.IOException;
import java.util.Scanner;

import br.com.ufc.crateus.Entidades.Veiculos;

public class Menu {
	private static Scanner input;
	private static Veiculos veiculos = new Veiculos();

	public static void mostrarMenu() throws IOException {
		input = new Scanner(System.in);
		int op = 1;
		
		while(op != 0) {
			System.out.println("-------------Menu de Opcoes-------------");
			System.out.println("\n1-Adcionar um veiculo.");
			System.out.println("\n2-Remover um veiculo.");
			System.out.println("\n3-Buscar um veiculo pela Placa.");
			System.out.println("\n4-Buscar um veiculo pela Modelo.");
			System.out.println("\n5-Buscar um veiculo pela Marca.");
			System.out.println("\n6-Buscar um veiculo pelo Ano.");
			System.out.println("\n7-Buscar um veiculo pelo Fabricante.");
			System.out.println("\n8 Mostrar todos os veiculos cadastrados.");
			System.out.println("\n0-Sair do Programa.");
			System.out.println("\n\nDigite a opcao desejada.");
			
			op = input.nextInt();
			switch(op) {
				default:
						System.out.println("Opcao invalida!");
						break;
						
				case 0: 
						System.out.println("Programa Encerrado!");
						break;
						
				case 1:
						veiculos.adicionaVeiculo();
						break;
						
				case 2: 
						veiculos.removeVeiculo();
						break;
					
				case 3:
						veiculos.buscaPorPlaca();
						break;
				
				case 4: 
						veiculos.buscaPorModelo();
						break;
				
				case 5:
						veiculos.buscaPorMarca();
						break;
				
				case 6:
						veiculos.buscaPorAno();
						break;
						
				case 7: 
					veiculos.buscaPorFabricante();
					break;
					
				case 8:
						veiculos.mostraVeiculosCadastrados();
			}
		}
	}
}
