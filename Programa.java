import java.util.StringTokenizer;
import java.io.*;
import java.util.List;

public class Programa
{
    public static void main (String[] args)
    {
		int cont = 0;
		try
		{
			System.out.println("Digite o nome do seu arquivo!");
			String arq = Teclado.getUmString();

			Leitor leitor = new Leitor(arq);

			while(!leitor.fimDoArquivo())
			{
				Matriz m = new Matriz(leitor.getSistema());
				Matriz sistema = new Matriz(m); // clona-se a matriz lida, para não estragar seus valores
				Resolvedor resolvedor = new Resolvedor(sistema);
				if(!resolvedor.isSolucionavel())
				{
					System.out.println(cont+1 + "a Equação: sem solução");
					cont++;
					continue;
				}
				if (resolvedor.temZeroDiag())
				{
					try
					{
						resolvedor.tirarZeroDiag();
					}
					catch(Exception erro)
					{
						System.out.println(cont+1 + "a Equação: sem solução");
						cont++;
						continue;
					}
				}

				resolvedor.resolver();
				System.out.println(cont+1 + "a Equação: \n " + resolvedor.resultado() + "\n");

				cont++;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());
		}
    }
}