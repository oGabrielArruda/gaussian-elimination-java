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

    public boolean isSolucionavel() // divisões
    {
		return true;
	}

	public boolean temZeroDiag() throws Exception
	{
		for(int linha = 0; linha < this.qtdEquacoes; linha++)
			if(this.sistema.getValor(linha, linha) == 0)
				return true;
		return false;
	}

	public void trocarOrdem()
	{

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

	public String resultado()
	{
		String ret = "";
		try
		{
			for(int i = 0; i < this.qtdEquacoes; i++)
			{
				ret += i+"a incognita: " + this.sistema.getValor(i,this.qtdEquacoes+1);
			}
		}
		catch(Exception e)
		{} // sei que não vai dar erro
		return ret;
	}
}