package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Livro;
import ecommerce.repository.*;

public class LivrosController implements EcommerceRepository
{
	ArrayList<Livro>	livros = new ArrayList<Livro>();
	int 				id = 0;
	
	public int	genNumber(){
		return ++id;
	}
	
	public Livro searchInCollection(int number)
	{
		for (var livro : livros)
		{
			if (livro.getId() == number)
				return (livro);
		}
		return (null);
	}
	
	@Override
	public void listAll()
	{
		livros.forEach(element -> {
			element.visualize();
		});
	}

	
	@Override
	public boolean searchNumber(int id)
	{
		var livro = searchInCollection(id);
		
		if (livro != null)
		{
			livro.visualize();
			return (true);
		}
		else
			System.out.printf("\nO livro %d não foi encontrado!\n\n", id);
		return (false);
	}

	@Override
	public void register(Livro book)
	{	
		var livro = searchInCollection(book.getId());
		
		if (livro == null)
		{
			livros.add(book);
			System.out.printf("\nO livro %s foi cadastrado com sucesso!\n", book.getTitle());
		}
		else
			System.out.println("\nEste livro já se encontra na coleção!");
	}

	@Override
	public void update(Livro book)
	{		
		var livro = searchInCollection(book.getId());
				
		livros.set(livros.indexOf(livro), book);
		System.out.printf("\nA conta número %d foi atualizada com sucesso!\n", book.getId());
	}

	@Override
	public void delete(int id)
	{
		var livro = searchInCollection(id);
		
		if (livro != null)
		{
			livros.remove(livro);
			System.out.printf("\nO livro %d foi removido com sucesso!\n", id);
		}
		else
			System.out.printf("\nO livro %d não foi encontrado!", id);
	}
	
	@Override
	public Livro buy(int id, float value)
	{
		var livro = searchInCollection(id);
		
		if (value >= livro.getPrice())
		{
			livros.remove(livro);
			System.out.println("\nVenda efetuada com sucesso! Livro removido do catálogo.");
			return (livro);
		}
		else
			System.out.println("\nVocê não tem saldo suficiente para comprar esse livro!");
		return (null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
