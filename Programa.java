import java.util.StringTokenizer;
import java.io.*;

public class Programa
{
    public static void main (String[] args)
    {
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite o nome do seu arquivo!");
			String arq = reader.readLine();
			Leitor leitor = new Leitor(arq);

			while(!(leitor.acabouArquivo))
			{
				Matriz mat = new Matriz(leitor.getSistema(nmr));
				if(!(mat.isSolucionavel))
				{
					System.out.println("Sistema sem solução!\n\n");
				}
				else
				{
				   if(mat.temZeroDiag())
						mat.trocarOrdem();
					mat.resolver();
					System.out.println(mat.resultado);
			    }

			    nmr++;
			}
		}
		catch(Exception ex)
		{

		}
    }
}