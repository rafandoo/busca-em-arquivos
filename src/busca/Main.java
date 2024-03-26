package busca;

import com.busca.buscador.BuscadorArquivos;
import com.busca.servico.BuscaNome;

public class Main {

	public static void main(String[] args) {
		BuscaNome bn = new BuscaNome(2, "ALi");
		
		BuscadorArquivos ba = new BuscadorArquivos(bn, "C:\\Users\\rafael.bekhauser\\Documents\\buscaArquivos\\files\\arquivosNomes");
		
		ba.criarThreads();
	}

}
