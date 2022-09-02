package com.example.compilador;

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
        msg.setText("Compilação de programas ainda não foi implementada");
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

    public void salvarTexto(String texto, File file ){
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(texto);
            writer.close();
        } catch (IOException ex) {
            return;
        }
    }
}