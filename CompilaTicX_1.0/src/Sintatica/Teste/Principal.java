package Sintatica.Teste;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import Sintatica.Teste.Lexer;
import java_cup.runtime.Symbol;

public class Principal {

	public static void main(String[] args) throws IOException {
		String caminho ="C:\\Users\\mat3u\\Desktop\\Compiladores\\CompilaTIC\\CompilaTicX_1.0\\src\\AnalisadorLexico\\teste1.txt";
		AnaliseSint ana = new AnaliseSint();
		ana.analisaSint(caminho);
		System.out.println(ana.resposta);
	}

}
