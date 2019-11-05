public class TesteLeitor
{
	public static void main(String[] args)
	{
		Leitor leitor = null;

		System.out.println("Testes do Construtor:");
		// passando uma string vazia => ""
		try
		{
			String diretorio = "";
			leitor = new Leitor(diretorio);
			System.out.println("Conseguiu armazenar um diretorio vazio");
		}
		catch(Exception erro)
		{
			System.err.println("Erro: " + erro.getMessage());
		}

		// passando uma string nula => null
		try
		{
			String diretorio = null;
			leitor = new Leitor(diretorio);
			System.out.println("Conseguiu armazenar um diretorio nulo");
		}
		catch(Exception erro)
		{
			System.err.println("Erro: " + erro.getMessage());
		}

		// passando o diretório correto
		try
		{
			String diretorio = "gauss.txt";
			leitor = new Leitor(diretorio);
			System.out.println("Conseguiu armazenar um diretorio não nulo");
		}
		catch(Exception erro)
		{
			System.err.println("Erro: " + erro.getMessage());
		}
		System.out.println();

		System.out.println("Teste da leitura de um arquivo:");
		// leitura do arquivo
		double[][] matriz = null;
		try
		{
			while(leitor.fimDoArquivo())
			{
				matriz = leitor.getSistema();
			}
			System.out.println("CONSEGUIU LER O ARQUIVO");
		}
		catch(Exception erro)
		{
			System.err.println("Erro: " + erro.getMessage());
		}
		System.out.println();

		System.out.println("Testes do equals:");
		// equals
		Leitor outroLeitor = null;
		try
		{
			outroLeitor = new Leitor("gauss.txt");
		}
		catch (Exception erro)
		{ } // sei que não vai dar erro

		if (leitor.equals(leitor))
			System.out.println("O LEITOR É IGUAL AO LEITOR");
		else
			System.out.println("O LEITOR NÃO É IGUAL AO LEITOR");

		if (leitor.equals(outroLeitor))
			System.out.println("O LEITOR É IGUAL AO OUTROLEITOR");
		else
			System.out.println("O LEITOR NÃO É IGUAL AO OUTROLEITOR");

		if (outroLeitor.equals(outroLeitor))
			System.out.println("O OUTROLEITOR É IGUAL AO OUTROLEITOR");
		else
			System.out.println("O OUTROLEITOR NÃO É IGUAL AO OUTROLEITOR");

		if (outroLeitor.equals(leitor))
			System.out.println("O OUTROLEITOR É IGUAL AO LEITOR");
		else
			System.out.println("O OUTROLEITOR NÃO É IGUAL AO LEITOR");
		System.out.println();

		System.out.println("Teste do toString:");
		// toString
		System.out.println(leitor);
	}
}