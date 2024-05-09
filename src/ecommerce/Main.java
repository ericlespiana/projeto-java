package ecommerce;

import ecommerce.util.Cores;
import ecommerce.controller.LivrosController;
import ecommerce.model.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner				readIn = new Scanner(System.in);
		LivrosController	livros = new LivrosController();
		Livro				livro = null;
		String				nameBook = "", nameAuthor = "", language = "", cover = "", size = "";
		int					option = 0, pages = 0, type = 0, number = 0;;
		float				value = 0.0f;		
		
		do
		{
			System.out.println();
			System.out.println(Cores.TEXT_YELLOW + "********************************************\n");
			System.out.println("               ECOMMERCE              \n");
			System.out.println("********************************************\n");
			
			System.out.println("\t 1 - Listar todos os Produtos");
			System.out.println("\t 2 - Buscar Livro por ID");
			System.out.println("\t 3 - Cadastrar novo Livro");
			System.out.println("\t 4 - Atualizar Dados do Conta");
			System.out.println("\t 5 - Deletar Livro");
			System.out.println("\t 6 - Comprar Livro");
			System.out.println("\t 7 - Sair");
			System.out.println("                                                     ");
			System.out.println("********************************************" + Cores.TEXT_RESET);
			
			try
	        {
				System.out.print("Entre com a opção desejada: ");
				option = readIn.nextInt();
				readIn.nextLine();
	        }
			catch(InputMismatchException e)
	        {
	            System.out.println("\nDigite um número inteiro dentro das opções do Menu!");
	            readIn.nextLine();
	            option = 0;
	        }
	        catch(NoSuchElementException e){
	        	keyPress();
	        }		
			
			System.out.println(Cores.TEXT_WHITE_BOLD + "");
			
			switch (option)
			{
				case 1:
					livros.listAll();
					keyPress();
					break;
				case 2:
					try
			        {
						System.out.print("Digite o número do livro que deseja procurar: ");
						number = readIn.nextInt();
			        }
					catch(InputMismatchException e)
			        {
						System.out.println(Cores.TEXT_RED_BOLD + "\nTipo de dado incorreto! Tente novamente." + Cores.TEXT_RESET);
			            readIn.nextLine();
			            break;
			        }
					livros.searchNumber(number);
					keyPress();
					break;
				case 3:
					System.out.println("\n ****** Cadastrando novo livro ******\n");
					
					try
					{
						System.out.print("Qual o nome do Livro: ");
						nameBook = readIn.nextLine();
						System.out.print("Qual o nome do Autor: ");
						nameAuthor = readIn.nextLine();
						System.out.print("Quantas páginas tem o livro: ");
						pages = readIn.nextInt();
						System.out.print("Qual o preço do livro R$: ");
						value = readIn.nextFloat();
						readIn.nextLine();
						System.out.print("Qual o idioma do livro R$: ");
						language = readIn.nextLine();
						System.out.print("Qual o tipo do livro?\n"
								+ "[1] - Físico"
								+ "\n[2] - Digital\n"
								+ "Escolha uma opção: ");
						type = readIn.nextInt();
						readIn.nextLine();
						switch(type)
						{
							case 1 -> {
								System.out.print("A capa do livro é dura ou mole: ");
								cover = readIn.nextLine();
								livro = new LivroFisico(livros.genNumber(), pages, value, nameBook, nameAuthor, language, cover);
							}
							case 2 -> {
								System.out.print("Qual o tamanho do arquivo? (Ex: 50MB)\n");
								size = readIn.nextLine();
								livro = new LivroDigital(livros.genNumber(), pages, value, nameBook, nameAuthor, language, size);
							}
							default -> System.out.println("Opção inválida!");
						}
					}
					catch(InputMismatchException e)
			        {
						System.out.println(Cores.TEXT_RED_BOLD + "\nTipo de dado incorreto! Tente novamente." + Cores.TEXT_RESET);
			            readIn.nextLine();
			            break;
			        }
					livros.register(livro);
					keyPress();
					break;					
				case 4:
					try
					{
						System.out.print("Digite o número do livro que deseja atualizar: ");
						number = readIn.nextInt();
						readIn.nextLine();
						
						livro = livros.searchInCollection(number);
						
						if (livro != null)
						{						
							System.out.print("Digite o nome do novo Livro: ");
							nameBook = readIn.nextLine();
							System.out.print("Qual o nome do Autor: ");
							nameAuthor = readIn.nextLine();
							System.out.print("Quantas páginas tem o livro: ");
							pages = readIn.nextInt();
							System.out.print("Qual o preço do livro R$: ");
							value = readIn.nextFloat();
							readIn.nextLine();
							System.out.print("Qual o idioma do livro R$: ");
							language = readIn.nextLine();
							System.out.print("Qual o tipo do livro?\n"
									+ "[1] - Físico"
									+ "\n[2] - Digital\n"
									+ "Escolha uma opção: ");
							type = readIn.nextInt();
							readIn.nextLine();
							
							switch(type)
							{
								case 1 -> {
									System.out.print("A capa do livro é dura ou mole: ");
									cover = readIn.nextLine();
									livro = new LivroFisico(number, pages, value, nameBook, nameAuthor, language, cover);
								}
								case 2 -> {
									System.out.print("Qual o tamanho do arquivo? (Ex: 50MB)\n");
									size = readIn.nextLine();
									livro = new LivroDigital(number, pages, value, nameBook, nameAuthor, language, size);
								}
								default -> System.out.println("Opção inválida!");
							}
							livros.update(livro);
						}
						else
							System.out.printf("\nO número %d não foi encontrada!", number);
					}
					catch(InputMismatchException e)
			        {
						System.out.println(Cores.TEXT_RED_BOLD + "\nTipo de dado incorreto! Tente novamente." + Cores.TEXT_RESET);
			            readIn.nextLine();
			            break;
			        }
					keyPress();
					break;
				case 5:
					try
					{
						System.out.print("Digite o número do livro que deseja remover: ");
						livros.delete(readIn.nextInt());
					}
					catch(InputMismatchException e)
			        {
						System.out.println(Cores.TEXT_RED_BOLD + "\nTipo de dado incorreto! Tente novamente." + Cores.TEXT_RESET);
			            readIn.nextLine();
			            break;
			        }
					keyPress();
					break;
				case 6:
					try
					{
						do
						{			
							System.out.printf("Digite o número do livro que você deseja comprar - [0] para voltar ao Menu\nDigite sua opção: ");
							number = readIn.nextInt();
							
							if (number == 0)
								break ;
							if(livros.searchNumber(number))
							{
								System.out.printf("\nÉ este o título que deseja comprar? [1] Sim  [2] Não\nDigite sua opção: ");
								type = readIn.nextInt();
							}else
								type = 2;
						}while (type != 1 && type != 0);
						
						if (type == 1)
						{
							System.out.print("Digite o valor para o pagamento: ");
							value = readIn.nextFloat();
							livros.buy(number, value);
						}
					}
					catch(InputMismatchException e)
			        {
						System.out.println(Cores.TEXT_RED_BOLD + "\nTipo de dado incorreto! Tente novamente." + Cores.TEXT_RESET);
			            readIn.nextLine();
			            break;
			        }
					keyPress();
					break;
				case 7:
					System.out.println("\nProjeto Final Java!");
					about();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida!");
					keyPress();
					break;			
			}		
		}while (option != 7);
		readIn.close();
	}
	
	public static void about()
	{
		System.out.println(Cores.TEXT_BLUE_UNDERLINED + "");
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Ericles Piana da Silva");
		System.out.println("ericles.silva@genstudents.org");
		System.out.println("github.com/ericlespiana");
		System.out.println("*********************************************************" + Cores.TEXT_RESET);
	}
	
	public static void keyPress()
	{
	    try
	    {
	    	System.out.println(Cores.TEXT_RESET + "\nPressione enter para continuar...");
	        if (System.in.read() == -1)
	        {
	        	System.out.println("\nO programa chegou no final! EOF\n");
	        	System.exit(1);
	        }
	        	
	    }
	    catch(IOException e){
	        System.out.println("Ocorreu um erro ao esperar pela entrada do usuário.");
	    }
	}
}