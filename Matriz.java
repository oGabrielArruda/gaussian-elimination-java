public class Matriz
{
	protected double elem[][];

	public Matriz(int linhas, int colunas)
	{
		elem = new double[linhas][colunas];
	}

	public void inserir(Double valor, int linha, int coluna) throws Exception
	{
		if(linha < 0 || coluna < 0)
			throw new Exception("Espaço inválido!");
		this.elem[linha][coluna] = valor;
	}
}