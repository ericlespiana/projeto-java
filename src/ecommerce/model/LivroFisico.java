package ecommerce.model;

public class LivroFisico extends Livro
{	
	private String cover = "";
	
	public LivroFisico(int id, int pages, float price, String title, String authorName, String language,
			String cover)
	{
		super(id, pages, price, title, authorName, language);
		this.setFormat("Impresso em papel");
		this.cover = cover;
	}

	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}

	public void changeCover()
	{
		if (this.getCover().equalsIgnoreCase("Dura"))
			this.setCover("Mole");
		else
			this.setCover("Dura");
	}
	
	@Override
	public void visualize()
	{		
		super.visualize();
		System.out.printf("Capa do livro: %s\n", getCover());
	}	
}
