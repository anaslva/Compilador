package gals;
public interface ParserConstants
{
    int START_SYMBOL = 47;

    int FIRST_NON_TERMINAL    = 47;
    int FIRST_SEMANTIC_ACTION = 83;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 54, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, 54, 54, 54, 54, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, 54, 54, -1, -1, -1, -1, -1, -1, 54 },
        { -1,  3, -1,  3, -1,  3, -1, -1, -1, -1, -1,  3, -1, -1,  3,  3,  3, -1, -1,  1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  6, -1,  6, -1,  6, -1, -1, -1, -1, -1,  6, -1, -1,  6,  6,  6, -1, -1,  4,  5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 32, -1, 37, -1, 36, -1, -1, -1, -1, -1, 35, -1, -1, 34, 34, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 25, -1, 23, -1, -1, -1, -1, 22, -1, -1, 21, -1, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1, 26, 27, 28, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 47, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 44, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, 44, 44, 44, 44, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, 44 },
        { -1, 50, -1, 50, -1, 50, -1, -1, -1, -1, -1, 50, -1, -1, 50, 50, 50, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 48, 49, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 58, -1, -1, -1, -1, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, 59, -1, -1, -1, 58, 58, 58, 58, -1, -1, -1, -1, -1, 58, -1, -1, -1, -1, -1, 58, 58, -1, -1, -1, -1, -1, -1, 61 },
        { -1, 62, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, 62, 62, 62, -1, -1, -1, -1, -1, 62, -1, -1, -1, -1, -1, 62, 62, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 69, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 69, 69, 69, 69, -1, -1, -1, -1, -1, 69, -1, -1, -1, -1, -1, 69, 69, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 65, 67, 68, -1, -1, -1, -1, -1, 66, -1, -1, -1 },
        { -1, 73, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 73, 73, 73, 73, -1, -1, -1, -1, -1, 73, -1, -1, -1, -1, -1, 73, 73, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 78, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 79, 80, 81, 82, -1, -1, -1, -1, -1, 83, -1, -1, -1, -1, -1, 84, 85, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, 55, -1, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 56, 57, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 63, -1, 63, -1, -1, -1, 64, 64, 64, -1, -1, -1, -1, -1, 64, 63, 63, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 70, 70, -1, 70, -1, -1, -1, 70, 70, 70, 71, 72, -1, -1, -1, 70, 70, 70, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 74, 74, -1, 74, -1, -1, -1, 74, 74, 74, 74, 74, 75, 76, 77, 74, 74, 74, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, 19, -1, 20, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 51, -1, 51, -1, 51, 52, 52, -1, -1, -1, 51, -1, -1, 51, 51, 51, -1, -1, -1, -1, 52, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 45, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        {  98,  11,  14,  33,  49,  34,  99 },
        {  50,  51 },
        {  52,  51 },
        {  53,  51 },
        {  50,  51 },
        {  52,  51 },
        {  53,  51 },
        {   0 },
        {  20,  54,  75 },
        {  27,  55,  76 },
        {  30,  56,  29 },
        {  29 },
        {  30,  56,  29 },
        {  21,  54,  77 },
        {  27,  55, 113, 114,  78 },
        {  30,  56,  29 },
        {  29 },
        {  30,  56,  29 },
        {   2,  79 },
        {  28,  54 },
        {   0 },
        {  13 },
        {  10 },
        {   5 },
        {  18 },
        {   3 },
        {  23 },
        {  24 },
        {  25 },
        {  26 },
        {  19 },
        {   9 },
        {  57 },
        {  58 },
        {  59 },
        {  60 },
        {  61 },
        {   4,  29 },
        {   2, 115,  30,  48, 117,  29 },
        {  17,  32,  82,  54, 118,  31,  29 },
        {   0 },
        {  26, 105,  97,  28 },
        {  15,  32,  62,  31,  29 },
        {  16,  32,  62,  31, 100,  29 },
        {  48,  97,  81 },
        {  28,  62 },
        {   0 },
        {  12,  32,  48,  31, 107,  63,  64,   8, 109,  29 },
        {   7, 108,  63 },
        {   0 },
        {  53,  80 },
        {  63 },
        {   0 },
        {   6,  63,  22,  32,  48,  31,   8,  29 },
        {  65,  71 },
        {   0 },
        {  44,  65, 101,  71 },
        {  45,  65, 102,  71 },
        {  66 },
        {  19,  94 },
        {   9,  95 },
        {  46,  65,  96 },
        {  67,  72 },
        {   0 },
        {  68,  92,  67,  93 },
        {  35 },
        {  43 },
        {  36 },
        {  37 },
        {  69,  73 },
        {   0 },
        {  38,  69,  84,  73 },
        {  39,  69,  85,  73 },
        {  70,  74 },
        {   0 },
        {  40,  70,  86,  74 },
        {  41,  70,  87,  74 },
        {  42,  70, 103,  74 },
        {   2, 116 },
        {  23,  88 },
        {  24,  89 },
        {  25, 104 },
        {  26, 105 },
        {  32,  48,  31 },
        {  38,  70,  90 },
        {  39,  70,  91 }
    };

    String[] PARSER_ERROR =
    {
            "",
            //"Era esperado fim de programa",
            "esperado EOF",
            //"Era esperado identificador",
            "esperado identificador",
            // "Era esperado pr_boolean",
            "esperado pr_boolean",
            // "Era esperado break",
            "esperado break",
            // "Era esperado char",
            "esperado char",
            // "Era esperado do",
            "esperado do",
            // "Era esperado else",
            "esperado else",
            // "Era esperado end",
            "esperado end",
            // "Era esperado false",
            "esperado false",
            //"Era esperado float",
            "esperado float",
            // "Era esperado fun",
            "esperado fun",
            // "Era esperado if",
            "esperado if",
            // "Era esperado int",
            "esperado int",
            // "Era esperado main",
            "esperado main",
            // "Era esperado print",
            "esperado print",
            // "Era esperado println",
            "esperado println",
            // "Era esperado readln",
            "esperado readln",
            // "Era esperado string",
            "esperado string",
            // "Era esperado true",
            "esperado true",
            // "Era esperado val",
            "esperado val",
            // "Era esperado var",
            "esperado var",
            // "Era esperado while",
            "esperado while",
            // "Era esperado cint",
            "esperado cint",
            // "Era esperado cfloat",
            "esperado cfloat",
            // "Era esperado cchar",
            "esperado cchar",
            // "Era esperado cstring",
            "esperado cstring",
            // "Era esperado \":\"",
            "esperado :",
            // "Era esperado \",\"",
            "esperado ,",
            // "Era esperado \";\"",
            "esperado ;",
            // "Era esperado \"=\"",
            "esperado =",
            // "Era esperado \")\"",
            "esperado )",
            // "Era esperado \"(\"",
            "esperado (",
            // "Era esperado \"{\"",
            "esperado {",
            // "Era esperado \"}\"",
            "esperado }",
            // "Era esperado \"==\"",
            "esperado ==",
            // "Era esperado \"<\"",
            "esperado <",
            // "Era esperado \">\"",
            "esperado >",
            // "Era esperado \"+\"",
            "esperado +",
            // "Era esperado \"-\"",
            "esperado -",
            // "Era esperado \"*\"",
            "esperado *",
            // "Era esperado \"/\"",
            "esperado /",
            // "Era esperado \"%\"",
            "esperado %",
            // "Era esperado \"!=\"",
            "esperado !=",
            // "Era esperado \"&&\"",
            "esperado &&",
            // "Era esperado \"||\"",
            "esperado ||",
            // "Era esperado \"!\"",
            "esperado !",
            // "<programa> inválido",
            "esperado fun",
            //"<expressao> inválido",
            "esperado expressão",
            //"<lista_instrucoes> inválido",
            "esperado val var id readln print println if do break",
            //"<declaracao_constantes> inválido",
            "esperado val",
            //"<lista_ocorrencias> inválido",
            "esperado id break do if print println readln val var }",
            //"<declaracao_variaveis> inválido",
            "esperado var",
            //"<comando> inválido",
            "esperado id break do if print println readln",
            //"<lista_id> inválido",
            "esperado id",
            //"<tipo> inválido",
            "esperado boolean char float int string",
            //"<valor> inválido",
            "esperado false true constante_int constante_float constante_char constante_string",
            //"<cmd_atribuicao> inválido",
            "esperado id",
            //"<cmd_entrada> inválido",
            "esperado readln",
            //"<cmd_saida> inválido",
            "esperado print prinln",
            //"<cmd_selecao> inválido",
            "esperado if",
            //"<cmd_repeat> inválido",
            "esperado do",
            //"<lista_expressoes> inválido",
            "esperado expressão",
            //"<lista_comandos> inválido",
            "esperado id break do if print println readln",
            //"<else_opcional> inválido",
            "esperado else end",
            //"<elemento> inválido",
            "esperado expressão",
            //"<relacional> inválido",
            "esperado expressão",
            //"<aritmetica> inválido",
            "esperado expressão",
            //"<operador_relacional> inválido",
            "esperado == < > !=",
            //"<termo> inválido",
            "esperado expressão",
            //"<fator> inválido",
            "esperado expressão",
            //"<expressao_> inválido",
            "esperado expressão",
            //"<relacional_> inválido",
            "esperado expressão",
            //"<aritmetica_> inválido",
            "esperado expressão",
            //"<termo_> inválido",
            "esperado expressão",
            //"<declaracao_constantes1> inválido",
            "esperado : =",
            // "<declaracao_constantes2> inválido",
            "esperado ; =",
            //"<declaracao_variaveis2> inválido",
            "esperado : =",
            //"<declaracao_variaveis3> inválido",
            "esperado ; =",
            //"<lista_id2> inválido",
            "esperado : , = )",
            //"<lista_comandos1> inválido",
            "esperado  id break do else end if print println readln while",
            //"<lista_expressoes2> inválido"
            "esperado , )",
            //"<cte_string> inválido"
            "esperado id constante_string"
    };
}
