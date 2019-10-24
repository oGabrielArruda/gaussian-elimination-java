import java.util.StringTokenizer;
import java.io.*;

public class Sistemas
{
	protected Matriz
	protected int qtdEquacoes;

	public Matriz(double[][] sistema)
	{
		this.elem = new double[sistema.length][sistema[0].length]
		this.qtdEquacoes = sistema.length;
	}

    public boolean isSolucionavel() // divisões
    {

	}

	public boolean temZeroDiag()
	{
		for(int linha = 0; linha < qtdEquacoes; linha++)
			if(this.elem[linha][linha] == 0)
				return true;
		return false;
	}

	public void trocarOrdem()
	{

	}

	public void resolver()
	{
		for(int i = 0; i < qtdEquacoes; i++)
			this.setZerosNaColuna(i);
	}

	public void setZerosColuna(int col)
	{
		// verifica se o valor da diagonal principal é 1
		if(this.elem[col][col] != 1.0)
		{
			double x = this.elem[col][col];
			for(int coluna = 0; coluna < qtdEquacoes + 1; coluna++)
				this.elem[col][coluna] = this.elem[col][coluna] / x;
		}

		// deixa toda a coluna, com excecao do valor pertecente a diagonal, com 0
		for(int linha = 0; linha < qtdEquacoes; linha++)
		{
			double valor = this.elem[linha][col];
			if(valor != 0 && valor != this.elem[col][col])
			{
				for(int coluna = 0; coluna < qtdEquacoes+1; coluna++)
					this.elem[linha][coluna] = this.elem[col][coluna] * -valor;
			}
		}
	}

	public String resultado()
	{
		String ret = "";
		for(int i = 0; i < qtdEquacoes; i++)
		{
			ret += i+"a incognita: " + this.elem[qtdEquacoes][qtdEquacoes+1];
		}
	}
}