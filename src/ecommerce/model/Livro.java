package ecommerce.model;

public abstract class Livro
{
	private int		id = 0, pages;
	private float	price = 0.0f;
	private String	title = "";
	private String	authorName = "", language = "", format = "";
	
	public Livro(int id, int pages, float price, String title, String authorName, String language)
	{
		this.id = id;
		this.pages = pages;
		this.price = price;
		this.title = title;
		this.authorName = authorName;
		this.language = language;
	}

	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void visualize()
	{		
		System.out.println("\n***********************************************************");
		System.out.println("\t\t\tDados do Livro:");
		System.out.println("***********************************************************");
		System.out.println("ID do livro: " + this.id);
		System.out.println("Nome do livro: " + this.title);
		System.out.println("Nome do autor: " + this.authorName);
		System.out.println("Idioma do livro: " + this.language);
		System.out.println("Total de páginas: " + this.pages);
		System.out.println("Preço R$ " + this.price);
		System.out.println("Formato: " + this.format);
	}	
}
