grammar Cminus;

startRule
	:	type main LEFTCURLY progStatements RIGHTCURLY EOF;

main 	
	:	MAIN;
	
progStatements
	:	statement| statement progStatements| loops| loops progStatements;

statement
	:	(varDec|varAssign|printStatement) NULLCHAR | (funcDecParam| funcCallParam| funcPointerDec);

funcPointerDec 
        :       type LEFTPAREN POINTDEC varDec RIGHTPAREN ASSIGN POINT var;

type    :
                TYPE;

funcCallParam 
        :       var LEFTPAREN (var|exp) RIGHTPAREN | funcPointer;

funcPointer
        :       POINTDEC var LEFTPAREN (var|exp) RIGHTPAREN;
        
funcDecParam 
        :       type var LEFTPAREN varDec RIGHTPAREN LEFTCURLY progStatements 
                RETURN (var|exp|funcPointer) NULLCHAR RIGHTCURLY
        |       VOID var LEFTPAREN varDec RIGHTPAREN LEFTCURLY progStatements RIGHTCURLY;

printStatement 
	:	PRINT LEFTPAREN STRING RIGHTPAREN;
	
varDec
	:	type var|type var NULLCHAR;
	
varAssign
        :       var assignment mathExpr;

var	:	VAR;

assignment 
	:	ASSIGN| assignOp;

mathExpr 
	:	exp| exp op exp| var op exp| exp op var| var;

op
	:	PLUS| MINUS | DIVIDE | MULT;
	
exp 	
	:	INT|CHAR;
	
assignOp 
	:	PLUSEQUAL| MINUSEQUAL | MULTEQUAL | DIVIDEQUAL;
	
loops 	
	:	Ifloop LEFTPAREN ifConditions RIGHTPAREN LEFTCURLY progStatements RIGHTCURLY 
        |       Ifloop LEFTPAREN ifConditions RIGHTPAREN LEFTCURLY progStatements RIGHTCURLY 
                Elseloop LEFTCURLY progStatements RIGHTCURLY 
	|	Forloop LEFTPAREN forConditions RIGHTPAREN LEFTCURLY progStatements RIGHTCURLY;

ifConditions 
	:	var compare (exp|var);

forConditions
	:	var compare exp;
	
compare 
	:	LESSTHAN| GREATERTHAN| LESSEQUAL| GREATEREQUAL;		


TYPE :  'int'|'char';
VOID : 'void';
RETURN : 'return'
       ;
POINTDEC :'&'
         ; 
POINT : '@'
      ;
LEFTPAREN : '('
          ;
RIGHTPAREN : ')'
           ;
Ifloop	: 'if'
	;

Elseloop : 'else'
	 ;
	
Forloop	: 'for'
	;

PRINT   : 'printf'
	;


MAIN: 'main';
VAR: [a-z]+; 
LEFTCURLY: '{';
RIGHTCURLY: '}';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIVIDE : '/';
PLUSEQUAL : '+=';
MINUSEQUAL :'-=';
MULTEQUAL :'*=';
DIVIDEQUAL : '/=';
LESSTHAN : '<';
GREATERTHAN : '>';
LESSEQUAL : '<=';
GREATEREQUAL : '>='; 
ASSIGN    : '=';

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' ->skip
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) ->skip
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;





NULLCHAR : ';';
skip	:
	;

