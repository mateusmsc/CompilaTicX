package Analisador;

import java.io.File;

public class GeradorLexer {

	public static void main(String[] args) {
		
		//String Path = "D:/IFB/5º Semestre/Compiladores/CompilaTIC/CompilaTIC/language.lex";
		String Path = "D:\\IFB\\5º Semestre\\Compiladores\\CompilaTIC\\CompilaTicX_1.0\\src\\Analisador\\sintaxe.lex";
		File arquivo = new File(Path);
		jflex.Main.generate(arquivo);

	}
}
