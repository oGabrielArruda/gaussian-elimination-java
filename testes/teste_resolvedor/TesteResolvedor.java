public class TesteResolvedor
{
	public static void main(String[] args)
	{
		Matriz matriz = null;
		Resolvedor resolvedor = null;
		try
		{
			matriz = new Matriz(new double[3][3]);
			resolvedor = new Resolvedor(matriz);
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		System.out.println("Teste do isSolucionavel:");

		System.out.println("Matriz com zero em tudo...");
		try
		{
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					matriz.setValor(i, j, 0.0);
				}
			}
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro
		System.out.println(matriz);

		System.out.println("RESULTADO:");
		// verificando uma matriz com zeros em tudo
		try
		{
			if(resolvedor.isSolucionavel())
				System.out.println("Sistema solucionavel");
			else
				System.out.println("Sistema não solucionavel");
		}
		catch(Exception erro)
		{ }
		System.out.println();

		System.out.println("Matriz com equacoes irregulares:");
		try
		{
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					matriz.setValor(i, j, i+1);
				}
			}
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro
		System.out.println(matriz);

		System.out.println("RESULTADO:");
		// verificando uma matriz com valores reais, mas irregulares
		try
		{
			if(resolvedor.isSolucionavel())
				System.out.println("Sistema solucionavel");
			else
				System.out.println("Sistema não solucionavel");
		}
		catch(Exception erro)
		{ }
		System.out.println();

		System.out.println("Matriz com equacoes que realmente são solucionaveis");
		Leitor leitor = null;
		try
		{
			leitor = new Leitor("gauss.txt");
			matriz = new Matriz(leitor.getSistema());
			resolvedor = new Resolvedor(matriz);
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro
		System.out.println(matriz);

		System.out.println("RESULTADO:");
		// verificando uma matriz com valores reais, e solucionavel
		try
		{
			if(resolvedor.isSolucionavel())
				System.out.println("Sistema solucionavel");
			else
				System.out.println("Sistema não solucionavel");
		}
		catch(Exception erro)
		{ }
		System.out.println();

		System.out.println("Teste do temZeroDiag:");
		System.out.println("O Sistema...");
		System.out.println(matriz);
		if(resolvedor.temZeroDiag())
			System.out.println("Tem zeros na diagonal principal");
		else
			System.out.println("Não tem zeros na diagonal principal");
		System.out.println();

		System.out.println("Teste do tirarZeroDiag:");
		try
		{
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					matriz.setValor(i, j, 0.0);
				}
			}
			resolvedor = new Resolvedor(matriz);
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro
		System.out.println("O Sistema com zeros no sistema inteiro...");
		System.out.println(matriz);
		try
		{
			resolvedor.tirarZeroDiag();
		}
		catch(Exception erro)
		{
			System.out.println("O Sistema após tentar tirar zeros da diagonal:");
			System.out.println("Erro " + erro.getMessage());
		}
		System.out.println();

		Leitor l = null;
		try
		{
			l = new Leitor("gauss.txt");
			matriz = new Matriz(l.getSistema());
			resolvedor = new Resolvedor(matriz);
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro
		System.out.println("O Sistema com zeros na diagonal...");
		System.out.println(matriz);
		try
		{
			resolvedor.tirarZeroDiag();
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro
		System.out.println("O Sistem após tentar tirar zeros da diagonal:");
		System.out.println(matriz);
		System.out.println();

		System.out.println("Teste método resolver:");
		System.out.println("O Sistema...");
		System.out.println(matriz);
		try
		{
			resolvedor.resolver();
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro
		System.out.println("O Sistema após resolve-lo...");
		System.out.println(matriz);
		System.out.println();

		System.out.println("Teste do toString:");
		System.out.println(resolvedor);
		System.out.println();

		Leitor y = null;
		Matriz outraMatriz = null;
		Resolvedor outroResolvedor = null;
		try
		{
			y = new Leitor("input.txt");
			outraMatriz = new Matriz(y.getSistema());
			outroResolvedor = new Resolvedor(outraMatriz);
		}
		catch(Exception erro)
		{ } // sei que não vai dar erro

		System.out.println("Teste do equals:");
		if (resolvedor.equals(resolvedor))
			System.out.println("O RESOLVEDOR É IGUAL AO RESOLVEDOR");
		else
			System.out.println("O RESOLVEDOR NÃO É IGUAL AO RESOLVEDOR");

		if (resolvedor.equals(outroResolvedor))
			System.out.println("O RESOLVEDOR É IGUAL AO OUTRORESOLVEDOR");
		else
			System.out.println("O RESOLVEDOR ÑÃO É IGUAL AO OUTRORESOLVEDOR");

		if (outroResolvedor.equals(outroResolvedor))
			System.out.println("O OUTRORESOLVEDOR É IGUAL AO OUTRORESOLVEDOR");
		else
			System.out.println("O OUTRORESOLVEDOR NÃO É IGUAL AO OUTRORESOLVEDOR");

		if (outroResolvedor.equals(resolvedor))
			System.out.println("O OUTRORESOLVEDOR É IGUAL AO RESOLVEDOR");
		else
			System.out.println("O OUTRORESOLVEDOR NÃO É IGUAL AO RESOLVEDOR");
		System.out.println();

		System.out.println("Teste hashcode:");
		int val = matriz.hashCode();
		System.out.println(""+val);
		System.out.println();
	}
}