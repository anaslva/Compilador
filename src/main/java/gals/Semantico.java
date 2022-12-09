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


    private int contadorDeRotulo = 1;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        String tipo1 = "";
        String tipo2 = "";

        switch (action){
            case 1:
                verificaTipoNum(token);
                codigo.append(System.lineSeparator()).append("add");
                break;
            case 2:
                verificaTipoNum(token);
                codigo.append(System.lineSeparator()).append("sub");
                break;
            case 3:
                verificaTipoNum(token);
                codigo.append(System.lineSeparator()).append("mul");
                break;
            case 4:
                verificaDivisao(token);
                codigo.append(System.lineSeparator()).append("div");
                break;
            case 5:
                pilhaTipos.push(INT);
                codigo.append(System.lineSeparator())
                        .append("ldc.i8 ")
                        .append(token.getLexeme())
                        .append(System.lineSeparator())
                        .append("conv.r8");

                break;
            case 6:
                pilhaTipos.push(FLOAT);
                codigo.append(System.lineSeparator()).append("ldc.r8");
                codigo.append(System.lineSeparator()).append(token.getLexeme());
                break;
            case 7:
                tipo1 = pilhaTipos.pop();
                if(tipo1.equals(INT) || tipo1.equals(FLOAT)){
                    pilhaTipos.push(tipo1);
                } else {
                    throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética", token.getPosition());
                }
                break;
            case 8:
                tipo1 = pilhaTipos.pop();
                if(tipo1.equals(INT) || tipo1.equals(FLOAT)){
                    pilhaTipos.push(tipo1);
                } else {
                    throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética", token.getPosition());
                }
                codigo.append(System.lineSeparator()).append("ldc.i8").append(-1);
                codigo.append(System.lineSeparator()).append("conv.r8");
                codigo.append(System.lineSeparator()).append("mul");
                break;
            case 9:
                operdor = token.getLexeme();
                break;
            case 10:
                verificaDivisao(token);
                if (operdor.equals(">"))
                    codigo.append(System.lineSeparator()).append("ctg");
                else if (operdor.equals("<"))
                    codigo.append(System.lineSeparator()).append("clt");
                else if (operdor.equals("=="))
                    codigo.append(System.lineSeparator()).append("ceq");
                else
                    throw new SemanticError("tipos incompatíveis em expressão relacional", token.getPosition());
                break;
            case 11:
                pilhaTipos.push(BOOL);
                codigo.append(System.lineSeparator()).append("ldc.i4.1");
                break;
            case 12:
                pilhaTipos.push(BOOL);
                codigo.append(System.lineSeparator()).append("ldc.i4.0");
                break;
            case 13:
                verificaBool(token);
                codigo.append(System.lineSeparator()).append("ldc.i4.1");
                codigo.append(System.lineSeparator()).append("xor");
                break;
            case 14:
                tipo1 = pilhaTipos.pop();
                if (tipo1.equals(INT)) {
                    codigo.append(System.lineSeparator()).append("conv.i8");
                }

                codigo.append(System.lineSeparator())
                        .append("call void [mscorlib]System.Console::Write(")
                        .append(tipo1)
                        .append(")");

                break;
            case 15:
                codigo
                        .append(".assembly extern mscorlib {}").append(System.lineSeparator())
                        .append(".assembly _codigo_objeto{}").append(System.lineSeparator())
                        .append(".module   _codigo_objeto.exe").append(System.lineSeparator())
                        .append(System.lineSeparator())
                        .append(".class public _UNICA{").append(System.lineSeparator())
                        .append(".method static public void _principal() {").append(System.lineSeparator())
                        .append(".entrypoint");
                break;
            case 16:
                codigo
                        .append(" ret").append(System.lineSeparator())
                        .append("}").append(System.lineSeparator())
                        .append("}");
                break;
            case 17:
                codigo
                        .append(System.lineSeparator()).append("call void ")
                        .append(System.lineSeparator()).append("[mscorlib]System.Console::Write(string)");
                break;
            case 18:
                tipo1 = pilhaTipos.pop();
                tipo2 = pilhaTipos.pop();
                verificaBool(token);
                codigo
                        .append(System.lineSeparator()).append("and");
                break;
            case 19:
                tipo1 = pilhaTipos.pop();
                tipo2 = pilhaTipos.pop();
                verificaBool(token);
                codigo
                        .append(System.lineSeparator()).append("or");
                break;
            case 20:
                verificaDivisao(token);
                codigo
                        .append(System.lineSeparator()).append("div")
                        .append(System.lineSeparator()).append("conv.i8");
                break;
            case 21:
                pilhaTipos.push(CHAR);
                codigo
                        .append(System.lineSeparator());
                if (token.getLexeme().equals("\\n")) {
                    codigo
                            .append("\"\\n\"");
                    break;
                } else if (token.getLexeme().equals("\\s")) {
                    codigo
                            .append("\" \"");
                    break;
                } else if (token.getLexeme().equals("\\t")) {
                    codigo
                            .append("\"\\t\"");
                    break;
                }
                break;
            case 22:
                pilhaTipos.push(STRING);
                codigo
                        .append(System.lineSeparator()).append("ldstr ").append(token.getLexeme());
                break;
            case 24:
                codigo.append(System.lineSeparator())
                        .append("brfalse ")
                        .append(this.criaRotulo());
                break;
            case 25:
                String rotulo1= this.pilhaRotulos.pop();
                String rotulo2 = this.criaRotulo();
                this.codigo.append(System.lineSeparator()).append("br ").append(rotulo2);
                this.codigo.append(System.lineSeparator()).append(rotulo1).append(":");
                break;
            case 26:
                codigo
                        .append(System.lineSeparator()).append(pilhaRotulos.pop()).append(":");
                break;
            case 27:
                this.codigo.append(System.lineSeparator()).append(this.criaRotulo()).append(":");
                break;
            case 28:
                this.codigo.append(System.lineSeparator()).append("brtrue ").append(this.pilhaRotulos.pop());
                break;
            case 30:
                if (token.getLexeme().equals("int")) {
                    tipoVar = INT;
                } else if (token.getLexeme().equals("float")) {
                    tipoVar = FLOAT;
                } else if(token.getLexeme().equals("boolean")){
                    tipoVar = BOOL;
                }
                else {
                    tipoVar = token.getLexeme();
                }
                break;
            case 31:
                for (String id : listaId) {
                    tabelaSimbolos.put(id, tipoVar);
                    codigo
                            .append(System.lineSeparator())
                            .append(".locals(")
                            .append(tipoVar)
                            .append(" ")
                            .append(id)
                            .append(")");

                }
                listaId.clear();
                break;
            case 32:
                listaId.add(token.getLexeme());
                break;
            case 33:
                String id = token.getLexeme();
                String tipoId = tabelaSimbolos.get(id);
                pilhaTipos.push(tipoId);
                codigo
                        .append(System.lineSeparator())
                        .append("ldloc ").append(id);
                if (tipoId.equals(INT)) {
                    codigo
                            .append(System.lineSeparator())
                            .append("conv.r8");
                }
                break;
            case 34:
                String id2 = listaId.pop();
                String tipoid2 = tabelaSimbolos.get(id2);
                pilhaTipos.pop();
                if (tipoid2.equals(INT)) {
                    codigo
                            .append(System.lineSeparator()).append("conv.r8");
                }
                codigo
                        .append(System.lineSeparator()).append("stloc ").append(id2);
                break;
            case 35:
                for (String id3 : listaId) {
                    String classe = "";
                    String tipoid3 = tabelaSimbolos.get(id3);
                    if (tipoid3.equals(INT)) {
                        classe = "Int64";
                    } else if (tipoid3.equals(FLOAT)) {
                        classe = "Double";
                    }
                    codigo
                            .append(System.lineSeparator()).append("call string [mscorlib]System.Console::ReadLine()")
                            .append(System.lineSeparator()).append("call ")
                            .append(tipoid3)
                            .append(" [mscorlib]System.")
                            .append(classe)
                            .append("::Parse(string)")
                            .append(System.lineSeparator()).append("stloc ")
                            .append(id3);
                }
                listaId.clear();
                break;
        }
    }

    private void verificaBool(Token token) throws SemanticError {
        String tipo = pilhaTipos.pop();
        if(tipo.equals(BOOL)){
            pilhaTipos.push(BOOL);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão lógica", token.getPosition());
        }
    }
    private void verificaDivisao(Token token) throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();

        verificaNumValido(tipo1, token);
        verificaNumValido(tipo2, token);

        if(tipo1 == tipo2){
            pilhaTipos.push(tipo1);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética");
        }
    }

    private void verificaTipoNum(Token token) throws SemanticError{
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();

        verificaNumValido(tipo1, token);
        verificaNumValido(tipo2, token);

        if (tipo1.equals(FLOAT) || tipo2.equals(FLOAT)) {
            pilhaTipos.push(FLOAT);
        } else {
            pilhaTipos.push(INT);
        }
    }

    private void verificaNumValido(String tipo, Token token) throws SemanticError {
        if (!tipo.equals(INT) && !tipo.equals(FLOAT)) {
            throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética", token.getPosition());
        }
    }

    private String criaRotulo() {
        String rotulo = "l" + this.contadorDeRotulo;
        this.pilhaRotulos.push(rotulo);
        this.contadorDeRotulo++;
        return rotulo;
    }

    public String getCodigo() {
        return codigo.toString();
    }
}
