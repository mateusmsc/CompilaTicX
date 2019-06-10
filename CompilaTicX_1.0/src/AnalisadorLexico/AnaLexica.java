package AnalisadorLexico;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnaLexica {
	
	public String resultado = "";
	public String codFonte;
	public String erro="0";
	
	
	public void analisar(String caminho) throws IOException {
		int cont = 0;
		int contLinha = 1;

		String texto = lerArquivo(caminho);
		Lexer lexer = new Lexer(new StringReader(texto));
		codFonte = texto;
		//System.out.println(texto);
		
		while (true) {
			Token token = lexer.yylex();
			if (token == null) {
				//System.out.println(resultado);
				return;
			}
			else		
			// cases para mostrarmos a saida dos tokens
			switch (token) {

			case ERROR:
				cont++;
				resultado = resultado + "Erro na linha " + contLinha + ": Símbolo não reconhecido na coluna: " + cont +"\n";
				erro ="1"; 
				break;

			case ID:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<ID>: " + lexer.lexeme + "\n";
				break;

			case NUMERO:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<NUMERO>: " + lexer.lexeme + "\n";
				break;
				
			case VIRGULA:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL_VIRGULA>: " + lexer.lexeme + "\n";
				break;
				
			case OP_MENOR:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;	
			
			case OP_MENORIGUAL:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;	
				
			case OP_MAIOR:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;
			
			case OP_MAIORIGUAL:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;
			
			case OP_ADD:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_ARITMETICO>: " + lexer.lexeme + "\n";
				break;
				
			case OP_SUB:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_ARITMETICO>: " + lexer.lexeme + "\n";
				break;
				
			case OP_MULT:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_ARITMETICO>: " + lexer.lexeme + "\n";
				break;
				
			case OP_DIV:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_ARITMETICO>: " + lexer.lexeme + "\n";
				break;
				
			case OP_PERCENT:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_ARITMETICO>: " + lexer.lexeme + "\n";
				break;
				
			case PAR_ESQ:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL>: " + lexer.lexeme + "\n";
				break;
				
			case PAR_DIR:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL>: " + lexer.lexeme + "\n";
				break;
				
			case PR_PTVIRGULA:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL>: " + lexer.lexeme + "\n";
				break;
				
			case ASPAS:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL_ASPAS>: " + lexer.lexeme + "\n";
				break;
				
			case ASPASIMPLES:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL_ASPASIMPLES>: " + lexer.lexeme + "\n";
				break;
				
			case CHAVE_ESQ:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL>: " + lexer.lexeme + "\n";
				break;
			
			case CHAVE_DIR:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<SIMBOLO_ESPECIAL>: " + lexer.lexeme + "\n";
				break;
			
			case NUMERO_DECIMAL:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<NUMERO_DECIMAL>: " + lexer.lexeme + "\n";
				break;

			case OP_DIFERENTE:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;
			case OP_LOGICO_OR:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;

			case OP_LOGICO_AND:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;
			case OP_LOGICO_NOT:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_LOGICO>: " + lexer.lexeme + "\n";
				break;

			case COMENTARIO:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<COMENTARIO>: " + lexer.lexeme + "\n";
				break;

			case OP_ATRIBUICAO:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<OP_ARITMERICO>: " + lexer.lexeme + "\n";
				break;

			case PR_IF:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_INT:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_VAR:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_ELSE:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_CHAR:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_VOID:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_PRNT:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_PROC:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_FLOAT:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_WHILE:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;

			case PR_RETURN:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;
			case PR_MAIN:
				cont++;
				resultado = resultado + "Linha: " + contLinha + "<PALAVRA_RESERVADA>: " + lexer.lexeme + "\n";
				break;
			case LINHA:
				cont = 0;
				contLinha++;
				break;
			default:
				cont++;
				resultado = resultado + "Linha: " + cont + "<" + lexer.lexeme + ">: " + cont++;
				break;
			}
		}
	}

	private static String lerArquivo(String arquivo) throws IOException {
		Scanner scanner = new Scanner(new File(arquivo));
		scanner.useDelimiter("\\Z");
		return scanner.next();
	}

}
