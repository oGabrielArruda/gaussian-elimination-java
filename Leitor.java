import java.util.StringTokenizer;
import java.io.*;

public class Leitor
{
	private BufferedReader arquivo;

	public Leitor(String arq) throws Exception
	{
		arquivo =   new BufferedReader (
				        new FileReader (
		                           arq));
	}

	 public double[][] getSistema(int nmr)
     {
		double elem[][];
		try
		{
			for(int i = 0; i < nmr; i++)
			{
				int qtdEquacoes = Integer.parseInt(arquivo.readLine);
				StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());
				// descartar linhas até chegar em nmr-1;
			}
		}
     }

    public boolean acabouArquivo()
    {

	}
}