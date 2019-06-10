package Sintatica.Teste;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import java_cup.runtime.Symbol;


public class AnaliseSint {
	
	public static String resposta = "";
	
	
	public static void analisaSint(String caminho) throws IOException {
        //
		String sourcecode = lerArquivo(caminho);
        parser p = new parser(new Lexer(new StringReader(sourcecode))); 
        try {
             p.parse();
             resposta ="Analise Sintática realizada corretamente";
        } catch (Exception e) {
             Symbol s = p.getS();
             resposta= "Erro de Sintaxe. Espera-se um caractere antes de:\nLinha: " + (s.right+1) + " Coluna: " + s.left + ". Texto: \"" + s.value + "\"";
        }
	}
	
	private static String lerArquivo(String arquivo) throws IOException {
		Scanner scanner = new Scanner(new File(arquivo));
	    scanner.useDelimiter("\\Z");
	    return scanner.next();
	}
}
