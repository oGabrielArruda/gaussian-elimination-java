import java.util.StringTokenizer;
import java.io.*;
import java.util.List;

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
			List<Matriz> sistemas = leitor.getSistemas();
			for(int i = 0; i < sistemas.size(); i++)
			{
				Sistemas sis = new Sistemas(sistemas.get(i));
				if(!sis.isSolucionavel())
				{
					System.out.println("Sistema sem solução!");
					continue;
				}

				if(sis.temZeroDiag())
					sis.trocarOrdem();
				sis.resolver();
				System.out.println(sis.resultado());
			}
		}
		catch(Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());
		}
    }
}