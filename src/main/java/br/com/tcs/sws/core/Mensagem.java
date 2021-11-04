package br.com.tcs.sws.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Mensagem {

    public static void mensagemAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("ATEN√á√ÉO!");
        alert.setContentText(mensagem);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("/style/Dialog-Alert.css");
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.WINDOW_MODAL);
        alert.showAndWait();
    }

    public static void mesagemInfo(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Info!");
        alert.setContentText(mensagem);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("/style/Dialog-Info.css");
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        Thread thread = new Thread(() -> {
            try {
                // Wait for 5 secs
                Thread.sleep(10000);
                if (alert.isShowing()) {
                    Platform.runLater(() -> alert.close());
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        alert.showAndWait();
    }

    public static void mensagemErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erro Inesperado!");
        alert.setContentText(mensagem);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("/style/Dialog.css");
        dialogPane.getStyleClass().add("myDialog");
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        alert.showAndWait();
    }

    public static Boolean mensagemConfirm(String mensagem) {
        ButtonType sim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
        ButtonType nao = new ButtonType("N„o", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", sim, nao);
        alert.setHeaderText("ConfirmaÁ„o!");
        alert.setContentText(mensagem);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().addAll("/style/Dialog-Confirm.css", "/style/Buttons.css");
        Button button = (Button) alert.getDialogPane().lookupButton(sim);
        button.setPrefWidth(180);
        button.setPrefHeight(45);
        button.getStyleClass().add("btn-sim");
        Button button2 = (Button) alert.getDialogPane().lookupButton(nao);
        button2.setPrefWidth(180);
        button2.setPrefHeight(45);
        button2.getStyleClass().add("btn-nao");
        button.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT) {
                if (!button2.isDefaultButton()) {
                    button2.requestFocus();
                    button2.setDefaultButton(true);
                    button.setDefaultButton(false);
                }
            }
        });
        button2.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
                if (!button.isDefaultButton()) {
                    button.requestFocus();
                    button.setDefaultButton(true);
                    button2.setDefaultButton(false);
                }
            }
        });
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.UNDECORATED);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE;
    }

    public static void mensagemException(Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro inesperado");
        alert.setHeaderText("Capta√ß√£o de erros!");
        alert.setContentText("");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("/style/Dialog.css");
        dialogPane.getStyleClass().add("myDialog");
        Exception ex = e;

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");
        label.setStyle("-fx-text-fill: red");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

}
