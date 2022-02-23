package br.com.manipulandoarquivo.atividade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {
	
	public static void main(String[] args) {
		
		int opc = 0;
		
		try (Scanner scanner = new Scanner (System.in)) {
			do {
				
				System.out.println("\nATENÇÃO! TODOS OS ARQUIVOS SÃO CRIADOS/ SALVOS/ LIDOS/ BUSCADO DA AREA DE DESKTOP!!\n");
				System.out.println("----------------\n");
				System.out.println("Informe a opção que deseja realizar: ");
				System.out.println("1 - Criar/Salvar um arquivo em disco");
				System.out.println("2 - Ler/Buscar um arquivo do disco");
				System.out.println("3 - Sair do programa");
				System.out.println("----------------\n");
				
				opc= scanner.nextInt();
				
				switch (opc) {
				
				case 1: salvaArquivo();
				break;
				case 2: lerArquivo();
				break;
				case 3: System.out.println("Obrigada por usar o programa!!");
				break;
				
				default: System.out.println("Opção não implementada");
				break;
				}
				
			} while (opc != 3);
		}
		
		
	}

	public static void salvaArquivo() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		System.out.println("----------------");
		System.out.println("Informe o conteúdo do seu arquivo: ");
		String conteudoDoArquivo = scanner.nextLine(); //pega mais de uma palavra - string completa
		
		System.out.println("----------------");
		System.out.println("Informe o nome do arquivo que deseja salvar no disco: ");
		String nomeArquivo = scanner.next(); //next pega uma unica palavra
		
		String caminhoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\" +
		nomeArquivo + ".txt";//pega o nome do usuario que esta logado na maquina
	
		try {
			FileWriter objetoEscritor = new FileWriter(caminhoArquivo, false);
			objetoEscritor.write(conteudoDoArquivo.toString());
			objetoEscritor.close();
			
			System.out.println("\n----------------");
			System.out.println("Arquivo salvo com sucesso no diretorio descrito abaixo!");
			System.out.println("----------------");
			System.out.println(caminhoArquivo);
		}
		
		catch (IOException e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public static void lerArquivo() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----------------");
		System.out.println("Informe o nome do arquivo que deseja ler do disco");
		System.out.println("----------------");
		String nomeArquivo = scanner.next();
		
		String caminhoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\" +
				nomeArquivo + ".txt";//pega o nome do usuario que esta logado na maquina
		
		try {
			FileReader arquivoLeitura = new FileReader(caminhoArquivo);
			BufferedReader leitorArquivo = new BufferedReader(arquivoLeitura);
			
			String linha = leitorArquivo.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = leitorArquivo.readLine();
				
			}
			
			System.out.println("\n");
			leitorArquivo.close();
		}
		
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
