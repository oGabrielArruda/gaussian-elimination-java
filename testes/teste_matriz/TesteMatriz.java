public class TesteMatriz
{
	public static void main(String[] args)
	{
		Matriz matriz = null;
		double[][] mat = null;
		System.out.println("Testes construtor:");
		// passando uma matriz nula
		try
		{
			matriz = new Matriz(mat);
			System.out.println("Conseguiu armazenar uma matriz nula");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		// passando uma matriz instanciada
		try
		{
			mat = new double[1][1];
			matriz = new Matriz(mat);
			System.out.println("Conseguiu armazenar uma matriz instanciada");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}
		System.out.println();

		System.out.println("Testes para setar valor na matriz:");
		// passando linha e coluna negativa
		try
		{
			matriz.setValor(-1, -1, 2.0);
			System.out.println("Conseguiu armazenar");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		// passando linha e coluna maior que o tamanho da matriz
		try
		{
			matriz.setValor(2, 2, 2.0);
			System.out.println("Conseguiu armazenar");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		// passando linha e coluna corretas
		try
		{
			matriz.setValor(0, 0, 2.0);
			System.out.println("Conseguiu armazenar");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}
		System.out.println();

		System.out.println("Teste do get valor da matriz:");
		// passando linha e coluna negativa
		try
		{
			double val = matriz.getValor(-1, -1);
			System.out.println("Conseguiu retornar");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		// passando linha e coluna maior que o tamanho da matriz
		try
		{
			double val = matriz.getValor(2, 2);
			System.out.println("Conseguiu retornar");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		// passando linha e coluna corretas
		try
		{
			double val = matriz.getValor(0, 0);
			System.out.println("Conseguiu retornar");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}
		System.out.println();

		System.out.println("Teste do get linha inteira da matriz:");
		// passando linha negativa
		try
		{
			double[] vet = matriz.getLinha(-1);
			System.out.println("Conseguiu retornar a linha");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		// passando linha maior que o tamanho da matriz
		try
		{
			double[] vet = matriz.getLinha(2);
			System.out.println("Conseguiu retornar a linha");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}

		// passando linha correta
		try
		{
			double[] vet = matriz.getLinha(0);
			System.out.println("Conseguiu retornar a linha");
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro.getMessage());
		}
		System.out.println();

		System.out.println("Teste dos demais getters, que não disparam exceções:");
		System.out.println(matriz.getLinhas());
		System.out.println(matriz.getMatriz());
		System.out.println();

		System.out.println("Teste do toString:");
		System.out.println(matriz);
		System.out.println();

		System.out.println("Teste do equals:");
		Matriz outraMatriz = null;
		try
		{
			outraMatriz = new Matriz(new double[1][1]);
		}
		catch (Exception erro)
		{ } // sei que não vai dar erro

		if (matriz.equals(matriz))
			System.out.println("A MATRIZ É IGUAL A MATRIZ");
		else
			System.out.println("A MATRIZ NÃO É IGUAL A MATRIZ");

		if (matriz.equals(outraMatriz))
			System.out.println("A MATRIZ É IGUAL A OUTRAMATRIZ");
		else
			System.out.println("A MATRIZ NÃO É IGUAL A OUTRAMATRIZ");

		if (outraMatriz.equals(outraMatriz))
			System.out.println("A OUTRAMATRIZ É IGUAL A OUTRAMATRIZ");
		else
			System.out.println("A OUTRAMATRIZ NÃO É IGUAL A OUTRAMATRIZ");

		if (outraMatriz.equals(matriz))
			System.out.println("A OUTRAMATRIZ É IGUAL A MATRIZ");
		else
			System.out.println("A MATRIZ NÃO É IGUAL A MATRIZ");
		System.out.println();
	}
}