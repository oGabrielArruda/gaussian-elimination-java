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
		Matriz ret[] = new Matriz[10];
		int i = 0;

		while(arquivo.ready())
		{
			int qtdEquacoes = Integer.parseInt(arquivo.readLine());

			Matriz matriz = new Matriz(qtdEquacoes,qtdEquacoes+1);

			for(int linha = 0; linha < qtdEquacoes; linha++)
			{
				String l = arquivo.readLine();
				if(l.equals(""))
					l = arquivo.readLine();

				StringTokenizer quebrador = new StringTokenizer(l);
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
		}
		return ret;
     }
}