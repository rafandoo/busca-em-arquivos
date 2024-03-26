package com.busca.buscador;

import java.io.File;

import com.busca.servico.BuscaNome;

public class BuscadorArquivos {

	private BuscaNome buscaNome;
	private File path;
	
	public BuscadorArquivos(BuscaNome buscaNome, String path) {
		this.buscaNome = buscaNome;
		this.path = new File(path);
	}
	
	public void criarThreads() {
		int count = 1;
		for (File arquivo: path.listFiles()) {
			new Thread(
				new Tarefa(buscaNome, arquivo.toPath().toString()), 
				String.valueOf("T" + count)
			).start();
			count++;
		}
	}
}
