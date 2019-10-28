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

	public String toString()
	{
		String ret = "";
		for(int linha = 0; linha < this.linhas; linha++)
		{
			for(int coluna = 0; coluna < this.colunas; coluna++)
			{
				ret+= this.elem[linha][coluna] + " ";
			}
			ret+="\n";
		}

		return ret;
	}

	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Matriz mat = (Matriz)obj;

		if(this.colunas != mat.colunas || this.linhas != mat.linhas)
			return false;
		for(int linha = 0; linhas < this.linhas; linha++)
			for(int coluna = 0; coluna < this.colunas; coluna++)
				if(this.elem[linha][coluna] != mat.elem[linha][coluna])
					return false;
		return true;
	}

	public int hashCode()
	{
		int ret = 357;
		ret = ret*7 + new Integer(this.linhas).hashCode();
		ret = ret*7 + new Integer(this.colunas).hashCode();

		for(int linha = 0; linha < this.linhas; linha++)
			for(int coluna = 0; coluna < this.colunas; coluna++)
				ret = ret*7 + new Double(this.elem[linha][coluna]).hashCode();
		return ret;
	}
}