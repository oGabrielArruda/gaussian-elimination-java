public class Matriz
{
	protected double elem[][];
	protected int linhas;
	protected int colunas;

	public Matriz(int linhas, int colunas) throws Exception
	{
		if(linhas < 0 || colunas < 0)
			throw new Exception("Espaço inválido!");
		this.linhas = linhas;
		this.colunas = colunas;
		elem = new double[linhas][colunas];
	}

	public void setValor(int linha, int coluna, double valor) throws Exception
	{
		if(linha < 0 || coluna < 0)
			throw new Exception("Espaço inválido!");

		this.elem[linha][coluna] = valor;
	}

	public double getValor(int linha, int coluna) throws Exception
	{
		if(linha < 0 || coluna < 0)
			throw new Exception("Espaço inválido!");
		return this.elem[linha][coluna];
	}

	public int getLinhas()
	{
		return this.elem.length;
	}
}