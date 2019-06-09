package Sintatica.Teste;

import static AnalisadorLexico.Token.*;
import java_cup.runtime.Symbol;
import Sintatica.Teste.sym;

%%

//%public
%type java_cup.runtime.Symbol
%cup
%full
%class Lexer
%line
%char

%eofval{
    return new Symbol (sym.EOF, new String("Fim do arquivo"));
%eofval}

IGNORE = [\n|\t|\r]
SPACE = [ ]
//Identificador
ID = [a-z][a-zA-Z_|0-9]*

//Caracter literal
CHAR = \'[0-9|a-zA-Z|\n|\t| |:|\(|\)|,]\'

//Simbolos
SETOP = :=
LTH = <
MTH = >
LEQ = <=
MEQ = >=
EQ= =
DIFF= <>
PLUS = \+
MINUS = -
TIMES = \*
DIV = \/
MOD = %
AND = "and"
OR = "or"
NOT = "not"
LPAR = \(
RPAR = \)
VIRG = ,
PVIRG = ;
LCHA = \{
RCHA = \}
//Numeros
INT = [+-]{1}[0-9]+|[0-9]+
FLOAT = [[0-9]*,[0-9]+] | [[0-9]*,[0-9]+E[+-]{1}[0-9]*,[0-9]+]

//Comentarios
SINGLECOMMENT = \*{2}[\x20-\xED]*[\n|\r]
MULTICOMMENT = >{2}[\x20-\xED|\x09-\x0D]+<{2}



//Palavras chaves
KW_IF = "if"
KW_ELSE = "else"
KW_WHILE = "while"
KW_RETURN = "return"
KW_FLOAT = "float"
KW_CHAR = "char"
KW_VOID = "void"
KW_PRINT = "prnt"
KW_INT = "int"
KW_FUNCTION = "proc"
KW_VAR = "var"
%%



{KW_IF} { return new Symbol(sym.IF, yychar, yyline,yytext()); }
{KW_ELSE} { return new Symbol(sym.ELSE, yychar, yyline,yytext()); }
{KW_WHILE} { return new Symbol(sym.WHILE, yychar, yyline,yytext()); }
{KW_RETURN} { return new Symbol(sym.RETURN, yychar, yyline,yytext()); }
{KW_FLOAT} { return new Symbol(sym.FLOAT, yychar, yyline,yytext()); }
{KW_CHAR} { return new Symbol(sym.CHAR, yychar, yyline,yytext()); }
{KW_VOID} { return new Symbol(sym.VOID, yychar, yyline,yytext()); }
{KW_PRINT} { return new Symbol(sym.PRINT, yychar, yyline,yytext()); }
{KW_INT} { return new Symbol(sym.INT, yychar, yyline,yytext()); }
{KW_FUNCTION} { return new Symbol(sym.PROC, yychar, yyline,yytext()); }
{KW_VAR} { return new Symbol(sym.VAR, yychar, yyline,yytext()); }
{ID} { return new Symbol(sym.ID, yychar, yyline,yytext());}
{CHAR} {return new Symbol(sym.CHARL, yychar, yyline,yytext());}
{SETOP} {return new Symbol(sym.SETOP, yychar, yyline,yytext());}
{LTH} {return new Symbol(sym.LTH, yychar, yyline,yytext());}
{MTH} {return new Symbol(sym.MTH, yychar, yyline,yytext());}
{LEQ} {return new Symbol(sym.LEQ, yychar, yyline,yytext());}
{MEQ} {return new Symbol(sym.MEQ, yychar, yyline,yytext());}
{EQ} {return new Symbol(sym.EQ, yychar, yyline,yytext());}
{DIFF} {return new Symbol(sym.DIFF, yychar, yyline,yytext());}
{PLUS} {return new Symbol(sym.PLUS, yychar, yyline,yytext());}
{MINUS} {return new Symbol(sym.MINUS, yychar, yyline,yytext());}
{TIMES} {return new Symbol(sym.TIMES, yychar, yyline,yytext());}
{DIV} {return new Symbol(sym.DIV, yychar, yyline,yytext());}
{MOD} {return new Symbol(sym.MOD, yychar, yyline,yytext());}
{AND} {return new Symbol(sym.AND, yychar, yyline,yytext());}
{OR} {return new Symbol(sym.OR, yychar, yyline,yytext());}
{NOT} {return new Symbol(sym.NOT, yychar, yyline,yytext());}
{LPAR} {return new Symbol(sym.LPAR, yychar, yyline,yytext());}
{RPAR} {return new Symbol(sym.RPAR, yychar, yyline,yytext());}
{VIRG} {return new Symbol(sym.VIRG, yychar, yyline,yytext());}
{PVIRG} {return new Symbol(sym.PVIRG, yychar, yyline,yytext());}
{LCHA} {return new Symbol(sym.LCHA, yychar, yyline,yytext());}
{RCHA} {return new Symbol(sym.RCHA, yychar, yyline,yytext());}
{INT} { return new Symbol(sym.INTL, yychar, yyline,yytext()); }
{FLOAT} {return new Symbol(sym.FLOATL, yychar, yyline,yytext()); }
{SINGLECOMMENT} {}
{MULTICOMMENT} {}
{IGNORE} {}
{SPACE} {}



. {System.err.println("Caractere Ilegal: "+yytext());}