import java.util.StringTokenizer;
import java.io.*;

public class Resolvedor
{
	protected Matriz sistema;
	protected int qtdEquacoes;

	/**
	Construtor da classe Resolvedor.
	Passa-se um objeto da classe Matriz, contendo o sistema de equacões
	Em seguida seta os atributos sistema e qtdEquacoes
	@param sistema instância da classe Matriz
	@throws Exception caso ô objeto passado seja nulo
	*/
	public Resolvedor(Matriz sistema)
	{
		this.sistema = sistema;
		this.qtdEquacoes = sistema.getLinhas();
	}

	/**
	Verifica se o sistema tem solução.
	Percorre todas as as equações do sistema, e as dividem pelas outras equações
	Caso as divisões tenham todo o mesmo valor, retorna-se false
	Senão, retorna-se true
	@return true se as divisões tiverem pelo menos 1 valor diferente, false se tiverem todos valores iguais
	@throws Exception caso ocorra algum problema ao resgatar os valores
	*/
    public boolean isSolucionavel() throws Exception // divisões
    {
		for(int linha = 0; linha < this.qtdEquacoes-1; linha++)
		{
			for(int outraLinha = linha+1; outraLinha < this.qtdEquacoes; outraLinha++)
			{
				double[] jaFoi = new double[this.qtdEquacoes];
				for(int coluna = 0; coluna < this.qtdEquacoes; coluna++)
				{
					try
					{
						double valor = this.sistema.getValor(linha, coluna) / this.sistema.getValor(outraLinha,coluna);
						jaFoi[coluna] = valor;
					}
					catch(Exception ex)
					{
						throw new Exception("Problema ao verificar se é solucionável");
					}
				}

				double primeiroValor = jaFoi[0];
				int qtsVezes = 1;
				for(int i = 1; i < jaFoi.length; i++) // verifica se as divisões tiveram
				{									  // o mesmo resultado
					if(primeiroValor == jaFoi[i])
						qtsVezes++;
				}
				if(qtsVezes == jaFoi.length)
					return false;
			}
		}
		return true;
	}


	/**
	Retira os zeros da diagonal principal da matriz.
	O método faz com que as linhas "subam" uma posição.
	A subida é repetida até que não existam zeros na diagonal principal.
	@throws Exception caso seja tirar todos os zeros da diagoal
	*/
	public void tirarZeroDiag() throws Exception
	{
		int vezes = 0;
		try
		{
			while(temZeroDiag() && vezes != this.qtdEquacoes)
			{
				double[] primeiraLinha = this.sistema.getLinha(0);

				for(int linha = 0; linha < this.qtdEquacoes-1; linha++)
				{
					double[] deBaixo = this.sistema.getLinha(linha+1);
					for(int coluna = 0; coluna < this.qtdEquacoes + 1; coluna++)
					{
						this.sistema.setValor(linha, coluna, deBaixo[coluna]);
					}
				}
				int ultimaLinha = this.qtdEquacoes - 1;
				for(int coluna = 0; coluna < this.qtdEquacoes+1; coluna++)
				this.sistema.setValor(ultimaLinha, coluna, primeiraLinha[coluna]);
				vezes++;
			}
			if (vezes == this.qtdEquacoes)
			    throw new Exception("Sistema inválido");

		}
		catch(Exception erro)
		{
			throw new Exception("Troca inválida");
		}
	}

	/**
	Verifica se há zeros na diagonal principal da matriz.
	@return true caso exista 0 na diagonal principal, false senão existir
	*/
	public boolean temZeroDiag()
	{
		try
		{
			for(int linha = 0; linha < this.qtdEquacoes; linha++)
				if(this.sistema.getValor(linha, linha) == 0)
					return true;

		}
		catch(Exception erro)
		{ }
		return false;

	}

	/**
	Seta os valores da coluna como 0, menos os pertencentes a diagonal principal.
	Primeiro, se o valor na diagonal principal for diferente de 1, transforma-se ele em 1, dividindo a linha pel valor a ser transformado
	Após ter certeza de que o valor da diagonal principal é 1, setamos 0 nas demais linhas
	Fazemos isso pegando o valor da linha, e somamos com a linha que implementamos 1 (diagonal principal) multiplicada pelo inverso do valor que será transformado
	Ao fazer isso com todas as linhas e com todas as colunas, consequentemente o método encontrará o resultado
	*/
	private void setZerosColuna(int col) throws Exception
	{
		double x = this.sistema.getValor(col,col);

		// verifica se o valor da diagonal principal é 1
		if(x != 1.0)
		{
			int linha = col;
			for(int coluna = 0; coluna < this.qtdEquacoes + 1; coluna++)
				this.sistema.setValor(linha,coluna, this.sistema.getValor(linha,coluna) / x);
		}

		// deixa toda a coluna, com excecao do valor pertecente a diagonal, com 0
		for(int linha = 0; linha < this.qtdEquacoes; linha++)
		{
			double valor = this.sistema.getValor(linha,col);
			if(valor != 0 && linha != col)
			{
				for(int coluna = 0; coluna < qtdEquacoes+1; coluna++)
				{
				   double val = this.sistema.getValor(linha,coluna) + (this.sistema.getValor(col,coluna) * -valor);
				   this.sistema.setValor(linha,coluna, val);
				}
			}
		}
	}

	/**
	Chama o método que deixa as colunas com o valor 0.
	É feito um for para percorrer todas equações do sistema.
	Para cada equação, chama-se o método que seta os valores da coluna 'i' com 0.
	Consequentemente, a equação será resolvida.
	*/
	public void resolver() throws Exception
	{
			for(int i = 0; i < this.qtdEquacoes; i++)
				this.setZerosColuna(i);
	}

	/**
	String com os resultados do sistema.
	@return a string com os resultados.
	*/
	public String resultado() throws Exception
	{
		String ret = "";
		try
		{
			for(int i = 0; i < this.qtdEquacoes; i++)
			{
				ret += i+1 + "a incognita: " + this.sistema.getValor(i,this.qtdEquacoes) + "\n";
			}
		}
		catch(Exception e)
		{} // sei que não vai dar erro
		return ret;
	}

	/**
	Calcula e devolve o código hash da instância.
	@return o código hash.
	*/
	public int hashCode()
	{
		int ret = 356;
		ret = ret * 7 + this.sistema.hashCode();
		ret = ret * 7 + new Integer(this.qtdEquacoes).hashCode();

		if(ret < 0)
			ret = -ret;
		return ret;
	}

	/**
	Transforma e retorna a instância da classe em formato de String
	@return string com os valores da instância
	*/
	public String toString()
	{
		String ret = sistema.toString() + "\n";
		ret += "Quantidade de Equacoes: " + this.qtdEquacoes;
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

		Resolvedor res = (Resolvedor) obj;
		if(!(this.sistema.equals(res.sistema)))
			return false;
		if(this.qtdEquacoes != res.qtdEquacoes)
			return false;
		return true;
	}
}
