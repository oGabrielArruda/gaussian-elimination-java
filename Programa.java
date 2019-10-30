import java.util.StringTokenizer;
import java.io.*;
import java.util.List;

public class Programa
{
    public static void main (String[] args)
    {
		try
		{
			System.out.println("Digite o nome do seu arquivo!");
			String arq = Teclado.getUmString();

			Leitor leitor = new Leitor(arq);

			while(!leitor.fimDoArquivo())
			{
				Matriz sistema = new Matriz(leitor.getSistema());
				Resolvedor resolvedor = new Resolvedor(sistema);

			/*	if(!resolvedor.isSolucionavel())
				{
					System.out.println("Sistema sem solução!");
					continue;
				}

				if(resolvedor.temZeroDiag())
					resolvedor.trocarOrdem();
				resolvedor.resolver();*/
				System.out.println(resolvedor.resultado());
			}
		}
		catch(Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());
		}
    }
}