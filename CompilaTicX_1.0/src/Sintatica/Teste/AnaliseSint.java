package Sintatica.Teste;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import AnalisadorLexico.AnaLexica;
import java_cup.runtime.Symbol;


public class AnaliseSint {
	
	public static String resposta = "";
	//public static String error= "0";
	
	
	public static void analisaSint(String caminho, String erro) throws IOException {
        //
		String sourcecode = lerArquivo(caminho);
        parser p = new parser(new Lexer(new StringReader(sourcecode))); 
        
        
        
        try {
             p.parse();
             if(erro.equalsIgnoreCase("0"))
             {
            	 resposta ="Analise Sintática realizada corretamente";
             }
             else
            	 resposta = "Erros Léxicos\nNão proseegue para análise Sintática";
             
        } catch (Exception e) {
             Symbol s = p.getS();
             resposta= "Erro de Sintaxe.\n"+"Linha <"+(s.right+1)+">"+" "+"Espera-se um caractere válido \nantes do símbolo <" + s.value +">";
             //resposta= "Erro de Sintaxe. Espera-se um caractere antes de:Linha: " + (s.right+1) + " Coluna: " + s.left + ". Texto: \"" + s.value + "\"";
        }
	}
	
	private static String lerArquivo(String arquivo) throws IOException {
		Scanner scanner = new Scanner(new File(arquivo));
	    scanner.useDelimiter("\\Z");
	    return scanner.next();
	}
}
