package com.busca.servico;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class BuscaNome {
	
	private Semaphore semaphore;
	private String chave;
	
	public BuscaNome(int permissoes, String chave) {
		this.semaphore = new Semaphore(permissoes);
		this.chave = chave;
	}
	
	public void busca(String path) throws FileNotFoundException {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(new FileReader(path));
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] sLine = line.split(" ");
			for (String linha : sLine) {
				if (linha.toLowerCase().contains(this.chave.toLowerCase())) {
					System.out.printf("%s - Encontrado: %s, no arquivo %s. %s", 
						Thread.currentThread().getName(), 
						line, 
						path, 
						System.lineSeparator()
					);
				}
			}
		}
		semaphore.release();
	}

}
