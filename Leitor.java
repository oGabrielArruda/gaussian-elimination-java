import java.util.StringTokenizer;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Leitor
{
	protected BufferedReader arquivo;

	public Leitor(String arq) throws Exception
	{
		if (arq == null || arq == "")
			throw new Exception("Diretório inválido");
		this.arquivo = new BufferedReader (new FileReader (arq));
	}

	public boolean fimDoArquivo() throws Exception
	{
		/*if(this.arquivo == null)
			throw new Exception("Arquivo nulo");*/
		return !this.arquivo.ready();
	}

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

	 public int hashCode()
	 {
		int ret = 345;
		ret = ret*7 + this.arquivo.hashCode();
		return ret;
	 }

	 public String toString()
	 {
		 return this.arquivo.toString();
	 }
}