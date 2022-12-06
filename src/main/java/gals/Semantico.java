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

    //private final String CFLOAT = "float64";
    //private final String CINT = "int64";
    //private final String CCHAR = "char";
    //private final String CSTRING = "string";
    //private final String CBOOL = "bool";
    private int contadorDeRotulo = 0;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        String tipo1 = "";
        String tipo2 = "";
        //System.out.println("Ação #"+action+", Token: "+token);

        switch (action){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
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
}
