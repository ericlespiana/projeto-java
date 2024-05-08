package ecommerce.model;

public class LivroDigital extends Livro
{
	private String	fileSize = "";
	private int		font = 12;

	public LivroDigital(int id, int pages, float price, String title, String authorName, String language, String fileSize)
	{
		super(id, pages, price, title, authorName, language);
		this.setFormat("PDF");
		this.fileSize = fileSize;		
	}
	
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public int getFont() {
		return font;
	}
	public void setFont(int font) {
		this.font = font;
	}

	public void increaseFont(int number)
	{
		int	font = this.getFont();
		
		this.setFont(font + number);
		System.out.printf("\nNovo tamanho de fonte: %d\n", this.getFont());			
	}
	
	public void decreaseFont(int number)
	{
		int	font = this.getFont();
		
		if (font >= number)
		{
			this.setFont(font - number);
			System.out.printf("\nNovo tamanho de fonte: %d\n", this.getFont());
		}
		else
			System.out.printf("\nA fonte atingiu o tamanho mínimo");
	}
	
	@Override
	public void visualize()
	{		
		super.visualize();
		System.out.printf("Tamanho do livro: %s\n", getFileSize());
		System.out.printf("Tamanho da fonte: %d\n", getFont());
	}	
}
