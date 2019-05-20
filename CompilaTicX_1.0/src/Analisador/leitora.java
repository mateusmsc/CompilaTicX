package Analisador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class leitora {

	public static void main(String[] ags) throws IOException {
		
				// Inicializando Leitor do arquivo
				String path="D:\\IFB\\5º Semestre\\Compiladores\\CompilaTIC\\CompilaTicX_1.0\\src\\Analisador\\teste.txt";
				BufferedReader buffRead = new BufferedReader(new FileReader(path));
				String linha = "";

				// Lista que separará o .txt em 'linhas'
				List<String> linhas = new ArrayList<String>();

				// leitura do arquivo
				while (linha != null) {
					linha = buffRead.readLine();
					if (linha != null)
						// adiciona na Lista as linhas do .txt
						System.out.println(linha);
				}
				buffRead.close();

	}
}
