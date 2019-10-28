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

	 public Matriz[] getSistemas() throws Exception // retorna uma matriz de sistemas
     {
		Matriz ret[] = null;
		int i = 0;

		String linhaArq = arquivo.readLine();

		while(!linhaArq.equals(""))
		{
			int qtdEquacoes = Integer.parseInt(linhaArq);
			Matriz matriz = new Matriz(qtdEquacoes,qtdEquacoes+1);

			for(int linha = 0; linha < qtdEquacoes; linha++)
			{
				StringTokenizer quebrador = new StringTokenizer (arquivo.readLine());
				int coluna = 0;
				while(quebrador.hasMoreTokens())
				{
					Double valor = Double.parseDouble(quebrador.nextToken());
					matriz.setValor(linha, coluna, valor);
					coluna++;
				}
			}
			ret[i] = matriz;
			i++;
			linhaArq = arquivo.readLine();
		}
		return ret;
     }
}