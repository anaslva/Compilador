package gals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Semantico implements Constants
{
    private final Stack<String> pilhaTipos = new Stack<>();
    private final LinkedList<String> listaId= new LinkedList<>();
    private final StringBuilder codigo = new StringBuilder();

    private final HashMap<String, String> tabelaSimbolos = new HashMap<>();
    private final Stack<String> pilhaRotulos = new Stack<>();
    private String operdor = "";
    private String tipoVar = "";



    private final String FLOAT = "float64";
    private final String INT = "int64";
    private final String CHAR = "char";
    private final String STRING = "string";
    private final String BOOL = "bool";


    private int contadorDeRotulo = 0;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        String tipo1 = "";
        String tipo2 = "";
        //System.out.println("Ação #"+action+", Token: "+token);

        switch (action){
            case 1:
                verificaTipoNum();
                codigo.append(System.lineSeparator()).append("add");
                break;
            case 2:
               verificaTipoNum();
                codigo.append(System.lineSeparator()).append("sub");
                break;
            case 3:
                verificaTipoNum();
                codigo.append(System.lineSeparator()).append("mul");
                break;
            case 4:
                verificaDivisao();
                codigo.append(System.lineSeparator()).append("div");
                break;
            case 5:
                pilhaTipos.push(INT);
                codigo.append(System.lineSeparator())
                        .append("ldc.i8")
                        .append(token.getLexeme())
                        .append(System.lineSeparator())
                        .append("conv.r8");


                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;

            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
            case 24:
                break;
            case 25:
                break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                break;
            case 29:
                break;
            case 30:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                break;
            case 34:
                break;
            case 35:
                break;

        }

        System.out.println(codigo);
    }

    private void verificaDivisao() throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();

        verificaNumValido(tipo1);
        verificaNumValido(tipo2);

        if(tipo1 == tipo2){
            pilhaTipos.push(tipo1);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética");
        }
    }

    private void verificaTipoNum() throws SemanticError{
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();

        verificaNumValido(tipo1);
        verificaNumValido(tipo2);

        if (tipo1.equals(FLOAT) || tipo2.equals(FLOAT)) {
            pilhaTipos.push(FLOAT);
        } else {
            pilhaTipos.push(INT);
        }
    }

    private void verificaNumValido(String tipo) throws SemanticError {
        if (tipo.equals(INT) || tipo.equals(FLOAT)) {
            pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética");
        }
    }
}
