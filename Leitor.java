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

	 public Matriz[] getSistemas() // retorna uma matriz de sistemas
     {
		Matriz ret[] = null;
		int i = 0;

		try
		{
			while(arquivo.readLine() != null)
			{
				int qtdEquacoes = Integer.parseInt(arquivo.readLine());

				Matriz matriz = new Matriz(qtdEquacoes,qtdEquacoes+1);

				for(int linha = 0; linha < qtdEquacoes; linha++)
				{
					StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());
					for(int coluna = 0; coluna < qtdEquacoes+1; coluna++)
						matriz.setValor(linha, coluna, Double.parseDouble(quebrador.nextToken()));
				}
				ret[i] = matriz;
				i++;
			}
		}
		catch(Exception ex)
		{}

		return ret;
     }
}