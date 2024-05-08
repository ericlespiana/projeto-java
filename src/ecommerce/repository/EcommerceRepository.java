package ecommerce.repository;

import ecommerce.model.Livro;

public interface EcommerceRepository
{	
	//Account CRUD
	public void listAll();
	public void searchNumber(int id);
	public void	register(Livro book);
	public void update(Livro book);
	public void delete(int id);
	
//	//Account Methods
//	public void	remove(int number, float value);
//	public void deposit(int number, float value);
//	public void transfer(int originNumber, int targetNumber, float value);
}
