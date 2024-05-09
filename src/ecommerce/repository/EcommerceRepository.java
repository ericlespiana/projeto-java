package ecommerce.repository;

import ecommerce.model.Livro;

public interface EcommerceRepository
{	
	//Account CRUD
	public void listAll();
	public boolean searchNumber(int id);
	public void	register(Livro book);
	public void update(Livro book);
	public void delete(int id);
	public Livro buy(int id, float value);
	
}
