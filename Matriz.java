public class Matriz implements Cloneable
{
	protected double elem[][];
	protected int linhas;
	protected int colunas;

	/**
	Construtor da classe matriz.
	Seta os atributos da classe.
	@param matriz uma matriz de números reais
	@throws Exception caso o parâmetro seja nulo
	*/
	public Matriz(double[][] matriz) throws Exception
	{
		if(matriz == null)
			throw new Exception("Matriz nula");

		this.elem = matriz;
		this.linhas = matriz.length;
		this.colunas = matriz[0].length;
	}

	/**
	Seta o valor de uma posição especifica na matriz.
	@param linha linha desejada para inclusão
	@param coluna coluna desejada para inclusão
	@param valor valor real desejado para inclusão
	@throws Exception caso a linha ou a coluna sejam negativas ou maiores que a quantidade de linhas e colunas
	*/
	public void setValor(int linha, int coluna, double valor) throws Exception
	{
		if(linha < 0 || coluna < 0 || linha > this.linhas - 1 || coluna > this.colunas - 1)
			throw new Exception("Espaço inválido!");

		this.elem[linha][coluna] = valor;
	}

	/**
	Pega o valor em determinada posição da matriz.
	@param linha linha desejada
	@param coluna coluna desejada
	@return o valor do elemento na posição indicada
	@throws Exception caso a linha ou a coluna sejam negativas ou maiores que a quantidade de linhas e colunas
	*/
	public double getValor(int linha, int coluna) throws Exception
	{
		if(linha < 0 || coluna < 0 || linha > this.linhas - 1 || coluna > this.colunas - 1)
			throw new Exception("Espaço inválido!");
		return this.elem[linha][coluna];
	}

	/**
	Pega os valores de uma determinada linha.
	Percorre os valores da linha desejada e os adicionam em um vetor.
	Feito isso, retorna-se o vetor com os valores da linha
	@param linha linha desejada
	@return um vetor de números reais com os valores da linha desejada
	@throws Exception caso a linha seja inválida
	*/
	public double[] getLinha(int linha) throws Exception
	{
		if (linha < 0 || linha > this.linhas - 1)
			throw new Exception("Paramêtro inválido!");
		double[] aux = new double[this.colunas];
		for (int coluna = 0; coluna < this.colunas; coluna++)
		{
			aux[coluna] = this.elem[linha][coluna];
		}
		return aux;
	}

	/**
	Pega a quantidade de linhas da matriz
	@return quantidade de linhas da matriz
	*/
	public int getLinhas()
	{
		return this.elem.length;
	}

	/**
	Pega a matriz da instância.
	@return a matriz clonada
	*/
	public double[][] getMatriz()
	{
		return this.elem.clone();
	}

	/**
	Transforma e retorna a instância em formato de String
	@return string com os valores da instância
	*/
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

	/**
		Verifica se a instância é igual a outra.
		@param obj objeto a ser comparado com a instância
		@return true se os atributos forem iguais, false se não forem
	*/
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

	/**
	Calcula e devolve o código hash da instância.
	@return o código hash.
	*/
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

	/**
	Construtor de cópia da classe.
	Seta os atributos da instância com os do passado como parâmetro
	@param instância a ser copiada
	*/
	public Matriz(Matriz modelo) throws Exception
	{
		if (modelo == null)
			throw new Exception("Parametro inválido");

		this.elem = new double[modelo.linhas][modelo.colunas];
		this.linhas = modelo.linhas;
		this.colunas = modelo.colunas;;

		for (int i = 0; i < this.linhas; i++)
		{
			for(int j = 0; j < this.colunas; j++)
			{
				this.elem[i][j] = modelo.elem[i][j];
			}
		}
	}

	/**
	Clona a instância.
	@return a instância clonada
	*/
	public Object clone()
	{
		Matriz ret = null;
		try
		{
			ret = new Matriz(this);
		}
		catch(Exception erro)
		{ }
		return ret;
	}
}