package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrutaController {

	public void readFruit(String path) throws IOException {
		File dir = new File(path);
		if(dir.exists() && dir.isDirectory()) {
			File[] listFiles = dir.listFiles();
			for (File file : listFiles) {
				if(file.isFile()) {
					if(file.getName().equals("generic_food.csv")) {
						FileInputStream fluxo = new FileInputStream(file);
						InputStreamReader leitor = new InputStreamReader(fluxo);
						BufferedReader buffer = new BufferedReader(leitor);
						String linha = buffer.readLine();
						while (linha != null) {
							String[] a = linha.split(";");
							if(a[2].toLowerCase().contains("fruit"))
								System.out.println(linha.replace(";", "\t"));
							linha = buffer.readLine();
						}
						buffer.close();
						leitor.close();
						fluxo.close();
					}
				}
			}
		}
		else {
			throw new IOException("Diretório inválido");
		}
	}
}
