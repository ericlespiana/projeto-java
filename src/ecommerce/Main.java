package ecommerce;

import ecommerce.util.Cores;
import ecommerce.model.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner readIn = new Scanner(System.in);
		int		option = 0;
		
		LivroFisico livro2 = new LivroFisico(1, 35, 25.30f, "Alice no País das maravílhas", "Lewis Carroll", "English", "Dura");
		LivroDigital livro3 = new LivroDigital(2, 35, 25.30f, "Harry Potter", "J. K. Rowling", "English", "35MB");
		
		do
		{
			System.out.println();
			System.out.println(Cores.TEXT_YELLOW + "*****************************************************\n");
			System.out.println("               ECOMMERCE              \n");
			System.out.println("*****************************************************\n");
			
			System.out.println("\t 1 - Listar todos os Produtos");
			System.out.println("\t 2 - Buscar Livro por ID");
			System.out.println("\t 3 - Atualizar Dados do Conta");
			System.out.println("\t 4 - Cadastrar novo Livro");
			System.out.println("\t 5 - Deletar Livro");
			System.out.println("\t 5 - Comprar Livro");
			System.out.println("\t 7 - Sair");
			System.out.println("                                                     ");
			System.out.println("*****************************************************" + Cores.TEXT_RESET);
			
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
					keyPress();
					break;
				case 2:
					keyPress();
					break;
				case 3:
					keyPress();
					break;
				case 4:
					keyPress();
					break;
				case 5:
					keyPress();
					break;
				case 6:
					System.out.println("\nProjeto Final Java!");
					about();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!");
					keyPress();
					break;			
			}		
		}while (option != 6);
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