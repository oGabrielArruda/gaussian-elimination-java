import java.util.StringTokenizer;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Leitor
{
	protected BufferedReader arquivo;

	/**
	Construtor da classe leitor.
	Vê se a string passada como parâmetro é válida, senão for, lança excessão
	Caso esteja válido, instancia um novo BufferedReader
	@throws Exception caso o nome do arquivo seja inválido
	*/
	public Leitor(String arq) throws Exception
	{
		if (arq == null || arq == "")
			throw new Exception("Diretório inválido");
		this.arquivo = new BufferedReader (new FileReader (arq));
	}

	/**
	Vê se o arquivo terminou.
	@return true se a leitura chegou a final do arquivo, false senão chegou
	*/
	public boolean fimDoArquivo() throws Exception
	{
		return !this.arquivo.ready();
	}

	/**
	Lê os valores do arquivo e os coloca em uma matriz.
	Primeiro, pega-se o primeiro valor que é a quantidade de equações do sistema
	Depois, instância-se uma nova matriz com a quantdade de linhas igual a quantidade de equações
	E a quantidade de colunas igual a quantidade de equações mais um
	Enfim, as linhas seguintes são lidas e são inseridas nas respectivas linhas e colunas na matriz
	@return a matriz com as equações
	*/
	 public double[][] getSistema() throws Exception // retorna uma matriz
     {
			int qtdEquacoes = Integer.parseInt(arquivo.readLine());

			double[][] ret = new double[qtdEquacoes][qtdEquacoes+1];

			for(int linha = 0; linha < qtdEquacoes; linha++)
			{
				String l = arquivo.readLine();
				if(l.equals(""))
					l = arquivo.readLine();

				StringTokenizer quebrador = new StringTokenizer(l);
				int coluna = 0;
				while(quebrador.hasMoreTokens())
				{
					ret[linha][coluna] = Double.parseDouble(quebrador.nextToken());
					coluna++;
				}
			}
			return ret;
     }

	/**
	Fecha o arquivo que está sendo lido.
	@throws Exception caso o arquivo esteja inválido
	*/
     public void fecharArquivo() throws Exception
     {
		try
		{
			this.arquivo.close();
		}
		catch(Exception ex)
		{
			throw new Exception("Erro ao fechar o arquivo");
		}
	 }

	/**
	Vê se a instância é igual a outra.
	@param obj instância a ser comparada
	*/
     public boolean equals(Object obj)
     {
		 if(this == obj)
		 	return true;
		 if(obj == null)
		 	return false;
		 if(this.getClass() != obj.getClass())
		 	return false;

		 Leitor leitor = (Leitor)obj;

		 if(!leitor.arquivo.equals(this.arquivo))
		 	return false;
		 return true;
	 }

	/**
	Calcula o código hash da instância.
	@return valor do código
	*/
	 public int hashCode()
	 {
		int ret = 345;
		ret = ret*7 + this.arquivo.hashCode();
		return ret;
	 }

	/**
	Retorna a instância em formato de string.
	*/
	 public String toString()
	 {
		return this.arquivo.lines().collect(Collectors.joining());
	 }
}