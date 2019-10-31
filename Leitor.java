import java.util.StringTokenizer;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Leitor
{
	private BufferedReader arquivo;

	public Leitor(String arq) throws Exception
	{
		arquivo =   new BufferedReader (
				        new FileReader (
		                           arq));
	}

	public boolean fimDoArquivo() throws Exception
	{
		if(this.arquivo == null)
			throw new Exception("Arquivo nulo");
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
}