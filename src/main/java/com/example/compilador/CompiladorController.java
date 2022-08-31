package com.example.compilador;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class CompiladorController implements Initializable {

    File fileAtual;
    Clipboard systemClipboard = Clipboard.getSystemClipboard();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

        String text = editor.getText();
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        systemClipboard.setContent(content);

    }

    @FXML
    public Button colar;
    private final KeyCombination atalhoColar = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN);

    public void onColarClick() {

    }
    @FXML
    public Button recortar;

    public void onRecortarClick() {

    }

    @FXML
    public Button compilar;
    private final KeyCode atalhoCompilar = KeyCode.F7;

    public void onCompilarClick() {
        msg.setText("Compilação de programas ainda não foi implementada");
    }

    @FXML
    public Button equipe;
    private final KeyCode atalhoEquipe = KeyCode.F11;

    public void onEquipeClick() {
        msg.setText("Ana Carolina da Silva e Lorhan Felipe Melo");
    }
    @FXML
    public TextArea editor;
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


        if (this.atalhoColar.match(event)) {
            onColarClick();
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
        //Create a task to load the file asynchronously
        Task<String> carregarArquivo = new Task<>() {
            @Override
            protected String call() throws Exception {
                BufferedReader reader = new BufferedReader(new FileReader(arquivoCarregado));
                //Use Files.lines() to calculate total lines - used for progress
                long contadorDeLinhas;
                try (Stream<String> stream = Files.lines(arquivoCarregado.toPath())) {
                    contadorDeLinhas = stream.count();
                }
                //Load in all lines one by one into a StringBuilder separated by "\n" - compatible with TextArea
                String linha;
                StringBuilder totalFile = new StringBuilder();
                long linhasLidas = 0;
                while ((linha = reader.readLine()) != null) {
                    totalFile.append(linha);
                    totalFile.append("\n");
                    updateProgress(++linhasLidas, contadorDeLinhas);
                }
                return totalFile.toString();
            }
        };
        //If successful, update the text area, display a success message and store the loaded file reference
        carregarArquivo.setOnSucceeded(workerStateEvent -> {
            try {
                editor.setText(carregarArquivo.getValue());
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

            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show save file dialog
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