package com.busca.buscador;

import java.io.FileNotFoundException;

import com.busca.servico.BuscaNome;

public class Tarefa implements Runnable {
	
	private BuscaNome buscaNome;
	private String path;
	
	public Tarefa(BuscaNome buscaNome, String path) {
		this.buscaNome = buscaNome;
		this.path = path;
	}
	
	@Override
	public void run() {
		try {
			this.buscaNome.busca(this.path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
