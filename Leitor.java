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

	 public List<Matriz> getSistemas() throws Exception // retorna uma matriz de sistemas
     {
		List<Matriz> lista = new ArrayList<Matriz>();
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
			lista.add(matriz);
			i++;
		}
		return lista;
     }
}