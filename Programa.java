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
			Matriz[] matrizSistemas = leitor.getSistemas();
			for(int i = 0; i < matrizSistemas.length; i++)
			{
				Sistemas sis = new Sistemas(matrizSistemas[i]);

			}
		}
		catch(Exception ex)
		{

		}
    }
}