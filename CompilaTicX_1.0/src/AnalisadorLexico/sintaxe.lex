/*Imports*/
package Analisador;

import static Analisador.Token.*;
%%
%class Lexer
%type Token

L = [a-zA-Z_]
D = [0-9]
NUM_DEC = [0-9]*,[0-9]+ | [0-9]+,[0-9]* 
WHITE=[ \b\t\r]

%{
public String lexeme;
%}


/* Definindo as Express?es Regulares */
%%
{WHITE} {/*Ignore*/}

/* Pular linha */
( "\n" )    {lexeme = yytext(); return LINHA;}

///* Operadores Lógicos */
//("and" | "or" |  "not" ) 
( "and")  {lexeme = yytext(); return OP_LOGICO_AND;}

( "or")  {lexeme = yytext(); return OP_LOGICO_OR;}

( "not")  {lexeme = yytext(); return OP_LOGICO_NOT;}

/*Operadores Relacionais */
( "<" | ">" | "<=" | ">=" | "=" | "<>")   {lexeme = yytext(); return OP_RELACIONAL;}

/* Operadores Atribuição */
(":=")      {lexeme = yytext(); return OP_ATRIBUICAO;}

/* Comentarios */
//(">>"*"<<")     {lexeme = yytext(); return COMENTARIO;}

/* Comentarios */
(">>"(.)*(.)"<<")     {lexeme = yytext(); return COMENTARIO;}

/* Operadores Aritim?ticos*/
("+" | "-" | "*" | "/" | "%" )    {lexeme = yytext(); return OP_ARITMETICO;}

/* Simbolos Especiais*/
( ")" | "(" | ";" | "{" | "}" ) 	{lexeme = yytext(); return SIMBOLO_ESPECIAL;}

/*Virgula*/
( "," ) 	{lexeme = yytext(); return VIRGULA;}

/* Palavras-chave reservadas */
/* Palavra reservada if*/
( "if")  {lexeme = yytext(); return PR_IF;}

/* Palavra reservada else*/
( "else")  {lexeme = yytext(); return PR_ELSE;}

/* Palavra reservada while*/
( "while")  {lexeme = yytext(); return PR_WHILE;}

/* Palavra reservada return*/
( "return")  {lexeme = yytext(); return PR_RETURN;}

/* Palavra reservada float*/
( "float")  {lexeme = yytext(); return PR_FLOAT;}

/* Palavra reservada char*/
( "char")  {lexeme = yytext(); return PR_CHAR;} 

/* Palavra reservada void*/
( "void")  {lexeme = yytext(); return PR_VOID;} 

/* Palavra reservada main*/
( "main")  {lexeme = yytext(); return PR_MAIN;} 

/* Palavra reservada prnt*/
( "prnt")  {lexeme = yytext(); return PR_PRNT;} 

/* Palavra reservada int*/
( "int")  {lexeme = yytext(); return PR_INT;} 

/* Palavra reservada proc*/
( "proc")  {lexeme = yytext(); return PR_PROC;}

/* Palavra reservada var*/
( "var")  {lexeme = yytext(); return PR_VAR;}  

/* ID */
{L}({L}|{D})* {lexeme=yytext(); return ID;}

/* NUMERO < 0 e >0*/
("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}

/* Numero Decimal */
({NUM_DEC}+) {lexeme = yytext(); return NUMERO_DECIMAL;}

. {return ERROR;}