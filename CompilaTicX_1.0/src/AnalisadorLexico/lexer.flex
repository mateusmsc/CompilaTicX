/*Imports*/
package AnalisadorLexico;

import static AnalisadorLexico.Token.*;
%%
%class Lexer
%type Token

D = [0-9]
NUM_DEC = [0-9]*,[0-9]+ | [0-9]+,[0-9]* 
WHITE=[ \b\t\r]
ASPAS = \"
ASPASIMPLES = \'
IDENTIFICADOR = [a-z][a-zA-Z_|0-9]*
SINGLECOMMENT = \*{2}[\x20-\xED]*[\n|\r]

%{
public String lexeme;
%}


%%
{WHITE} {/*Ignore*/}

/* Pular linha */
( "\n" )    {lexeme = yytext(); return LINHA;}

/*Operadores Logicos*/
( "and")  	{lexeme = yytext(); return OP_LOGICO_AND;}
( "or")  	{lexeme = yytext(); return OP_LOGICO_OR;}
( "not")  	{lexeme = yytext(); return OP_LOGICO_NOT;}

/*Operadores Relacionais */
( "<" )     {lexeme = yytext(); return OP_MENOR;}
( ">" )     {lexeme = yytext(); return OP_MAIOR;}
( "<=" )    {lexeme = yytext(); return OP_MENORIGUAL;}
( ">=" )    {lexeme = yytext(); return OP_MAIORIGUAL;}
( "=" )		{lexeme = yytext(); return OP_IGUAL;}
( "<>" )	{lexeme = yytext(); return OP_DIFERENTE;}
(":=")      {lexeme = yytext(); return OP_ATRIBUICAO;}

/* Comentarios */
(">>"(.)*(.)"<<")     {lexeme = yytext(); return COMENTARIO;}
{SINGLECOMMENT}     {lexeme = yytext(); return COMENTARIO_SIMPLES;}

/* Operadores Aritimeticos*/
("+")    	{lexeme = yytext(); return OP_ADD;}
("-")    	{lexeme = yytext(); return OP_SUB;}
("*")    	{lexeme = yytext(); return OP_MULT;}
("/")    	{lexeme = yytext(); return OP_DIV;}
("%")    	{lexeme = yytext(); return OP_PERCENT;}

/* Simbolos Especiais*/
( "(" ) 	{lexeme = yytext(); return PAR_ESQ;}
( ")" ) 	{lexeme = yytext(); return PAR_DIR;}
( ";" ) 	{lexeme = yytext(); return PR_PTVIRGULA;}
( "{" ) 	{lexeme = yytext(); return CHAVE_ESQ;}
( "}" ) 	{lexeme = yytext(); return CHAVE_DIR;}
( "," ) 	{lexeme = yytext(); return VIRGULA;}
{ASPAS} 	{lexeme = yytext(); return ASPAS;}
{ASPASIMPLES} 	{lexeme = yytext(); return ASPASIMPLES;}

/* Palavras-chave reservadas */
( "if")  {lexeme = yytext(); return PR_IF;}
( "else")  {lexeme = yytext(); return PR_ELSE;}
( "while")  {lexeme = yytext(); return PR_WHILE;}
( "return")  {lexeme = yytext(); return PR_RETURN;}
( "float")  {lexeme = yytext(); return PR_FLOAT;}
( "char")  {lexeme = yytext(); return PR_CHAR;} 
( "void")  {lexeme = yytext(); return PR_VOID;} 
( "main")  {lexeme = yytext(); return PR_MAIN;} 
( "prnt")  {lexeme = yytext(); return PR_PRNT;} 
( "int")  {lexeme = yytext(); return PR_INT;} 
( "proc")  {lexeme = yytext(); return PR_PROC;}
( "var")  {lexeme = yytext(); return PR_VAR;}  

/* ID */
//{L}({L}|{D})* {lexeme=yytext(); return ID;}
{IDENTIFICADOR} 	{lexeme =yytext(); return ID;}

/* NUMERO < 0 e >0*/
("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}

/* Numero Decimal */
({NUM_DEC}+) {lexeme = yytext(); return NUMERO_DECIMAL;}

. {return ERROR;}