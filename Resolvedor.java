import java.util.StringTokenizer;
import java.io.*;

public class Resolvedor
{
	protected Matriz sistema;
	protected int qtdEquacoes;

	public Resolvedor(Matriz sistema)
	{
		this.sistema = sistema;
		this.qtdEquacoes = sistema.getLinhas();
	}

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
				if (vezes == this.qtdEquacoes)
					throw new Exception("Sistema inválido");
			}

		}
		catch(Exception erro)
		{
			throw new Exception("Troca inválida");
		}
	}

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
	public void setZerosColuna(int col) throws Exception
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

	public void resolver() throws Exception
	{
			for(int i = 0; i < this.qtdEquacoes; i++)
				this.setZerosColuna(i);
	}

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

	public int hashCode()
	{
		int ret = 356;
		ret = ret * 7 + this.sistema.hashCode();
		ret = ret * 7 + new Integer(this.qtdEquacoes).hashCode();

		if(ret < 0)
			ret = -ret;
		return ret;
	}

	public String toString()
	{
		String ret = sistema.toString() + "\n";
		ret += "Quantidade de Equacoes: " + this.qtdEquacoes;
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

		Resolvedor res = (Resolvedor) obj;
		if(!(this.sistema.equals(res.sistema)))
			return false;
		if(this.qtdEquacoes != res.qtdEquacoes)
			return false;
		return true;
	}
}