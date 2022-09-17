package com.example.compilador;

import gals.LexicalError;
import gals.Lexico;
import gals.Token;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.stage.FileChooser;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.util.stream.Stream;

public class CompiladorController implements Initializable {

    File fileAtual;
    @FXML
    VirtualizedScrollPane scroll;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editor.setParagraphGraphicFactory(LineNumberFactory.get(editor));

        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }

    @FXML
    public Button novo;
    private final KeyCombination atalhoNovo = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);

    public void onNovoClick() {
        editor.clear();
        msg.clear();
        status.clear();
        this.fileAtual = null;
    }

    @FXML
    public Button abrir;
    private final KeyCombination atalhoAbrir = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);

    public void onAbrirClick() {
        escolherArquivo(null);
    }

    @FXML
    public Button salvar;
    private final KeyCombination atalhoSalvar = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);

    public void onSalvarClick() {
        salvarArquivo();
        System.out.println("salvou");
    }

    @FXML
    public Button copiar;

    public void onCopiarClick() {
        this.editor.copy();
    }

    @FXML
    public Button colar;

    public void onColarClick() {
        editor.paste();
    }

    @FXML
    public Button recortar;

    public void onRecortarClick() {
        this.editor.cut();
    }

    @FXML
    public Button compilar;
    private final KeyCode atalhoCompilar = KeyCode.F7;

    public void onCompilarClick() {
        msg.clear();
        int numeroLinha = 1;
        String[] linhas = this.editor.getText().split("\\r?\\n");
        Token tokenAtual = new Token(0, "", 0);
        StringBuilder s = new StringBuilder();

        try {

                Lexico lexico = new Lexico();
                lexico.setInput(new java.io.StringReader(editor.getText()));

                tokenAtual = lexico.nextToken();


                while (tokenAtual != null) {
                    String substringEditor = editor.getText().substring(0, tokenAtual.getPosition());
                    numeroLinha = 1;
                    int pos = 0;
                    while ((pos = substringEditor.indexOf("\n", pos) + 1) != 0) {
                        numeroLinha++;
                    }

                    if(tokenAtual.getId() != 28)
                        s.append("\n" +numeroLinha + "  " + getClasseLexema(tokenAtual.getId()) + "  " + tokenAtual.getLexeme());
                    tokenAtual = lexico.nextToken();
                }

            msg.setText(s.toString());

        } catch (LexicalError e) {
            String errorMessage = "Erro na linha %s - %s %s";
            if(e.getMessage().contains("cchar"))
                errorMessage = String.format(errorMessage, numeroLinha, "", "constante char inválida");
            else if(e.getMessage().contains(" esperado"))
                    errorMessage = String.format(errorMessage, getLineByPosition(e.getPosition()), editor.getText().charAt(e.getPosition()), " simbolo inválido");
            else if(e.getMessage().contains("string"))
                errorMessage = String.format(errorMessage, numeroLinha, "", " constante string inválida ou não finalizada");
            else if(e.getMessage().contains("bloco"))
                errorMessage = String.format(errorMessage, numeroLinha, "", " comentário de bloco inválido ou não finalizado");

            msg.appendText(errorMessage);
        }

        //msg.setText("Compilação de programas ainda não foi implementada");
    }

    @FXML
    public Button equipe;
    private final KeyCode atalhoEquipe = KeyCode.F1;

    public void onEquipeClick() {
        msg.setText("Ana Carolina da Silva e Lorhan Felipe Melo");
    }

    @FXML
    public CodeArea editor;
    @FXML
    public TextArea msg;
    @FXML
    public TextField status;

    public void gerenciarAtalhos(KeyEvent event) {
        if (this.atalhoNovo.match(event)) {
            onNovoClick();
        }

        if (this.atalhoAbrir.match(event)) {
            onAbrirClick();
        }

        if (this.atalhoSalvar.match(event)) {
            onSalvarClick();
        }

        if (event.getCode().equals(this.atalhoCompilar)) {
            onCompilarClick();
        }

        if (event.getCode().equals(this.atalhoEquipe)) {
            onEquipeClick();
        }
    }

    public void escolherArquivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File arquivoACarregar = fileChooser.showOpenDialog(null);
        if (arquivoACarregar != null) {
            passarArquivoParaEditor(arquivoACarregar);
        }
    }

    private Task<String> carregadorDoArquivo(File arquivoCarregado) {
        Task<String> carregarArquivo = new Task<>() {
            @Override
            protected String call() throws Exception {
                BufferedReader reader = new BufferedReader(new FileReader(arquivoCarregado));
                String linha;
                StringBuilder totalFile = new StringBuilder();
                while ((linha = reader.readLine()) != null) {
                    totalFile.append(linha);
                    totalFile.append("\n");

                }
                return totalFile.toString();
            }
        };

        carregarArquivo.setOnSucceeded(workerStateEvent -> {
            try {
                editor.clear();
                editor.appendText(carregarArquivo.getValue());
                status.setText(arquivoCarregado.getPath());
                fileAtual = arquivoCarregado;

            } catch (Exception e) {
                System.out.println(e);
                msg.setText("Não foi possível carregar arquivo de \n " + arquivoCarregado.getAbsolutePath());
                status.setText("Não foi possível carregar arquivo");
            }
        });

        return carregarArquivo;
    }

    private void passarArquivoParaEditor(File arquivoCarregado) {
        Task<String> carregarArquivo = carregadorDoArquivo(arquivoCarregado);
        carregarArquivo.run();
    }

    public void salvarArquivo() {
        if (this.fileAtual != null) {
            salvarTexto(editor.getText(), this.fileAtual);
        } else {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(null);
            this.fileAtual = file;
            if (this.fileAtual != null) {
                salvarTexto(editor.getText(), file);
                status.setText(this.fileAtual.getPath());
            }
        }
    }

    public void salvarTexto(String texto, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(texto);
            writer.close();
        } catch (IOException ex) {
            return;
        }
    }

    private String getLineByPosition(int position) {
        String content = editor.getText();
        int newLineQty = 0;
        for (int i = 0; i < content.length(); i++) {
            if (i == position) {
                break;
            }
            if (content.charAt(i) == '\n') {
                newLineQty++;
            }
        }

        return String.valueOf(newLineQty + 1);
    }

    private String getClasseLexema(int id) {
        if (id ==  2 || id == 23 )
            return "identificador";
        if (id > 2 && id <= 22)
            return "palavra reservada";
        if (id == 24)
            return "constante int";
        if (id == 25)
            return "constante float";
        if (id == 26)
            return "constante char";
        if (id == 27)
            return "constante string";
        if (id == 29)
            return null;
        if (id > 28)
            return "símbolo especial";

        return null;
    }
}