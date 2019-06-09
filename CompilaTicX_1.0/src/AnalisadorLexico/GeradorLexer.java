package AnalisadorLexico;

import java.io.File;

public class GeradorLexer {

	public static void main(String[] args) {
		
		//String Path = "D:/IFB/5º Semestre/Compiladores/CompilaTIC/CompilaTIC/language.lex";
		String Path = "C:\\Users\\mat3u\\Desktop\\Compiladores\\CompilaTIC\\CompilaTicX_1.0\\src\\AnalisadorLexico\\lexer.flex";
		File arquivo = new File(Path);
		jflex.Main.generate(arquivo);

	}
}
