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
				Matriz sistema = new Matriz(leitor.getSistema());
				System.out.println(sistema);
				Resolvedor resolvedor = new Resolvedor(sistema);
				if(!resolvedor.isSolucionavel())
				{
					System.out.println("Sistema sem solução!");
					continue;
				}
				if (resolvedor.temZeroDiag())
					resolvedor.tirarZeroDiag();
				System.out.println(sistema);
				resolvedor.resolver();
				System.out.println(sistema);
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