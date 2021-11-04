/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.core;

import java.io.IOException;
import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.setUserAgentStylesheet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Tadeu-PC
 */
public class Tela {

    public Stage stage;
    public Screen screen;
    public Parent root;

    public Tela(Stage stage) {
        this.stage = stage;
        this.screen = Screen.getPrimary();
    }

    public void moveTo(String tela) {
        try {
        	///sws/src/main/java/br/com/tcs/sws/presenter/pages/HomePage.fxml
            root = FXMLLoader.load(getClass().getResource("/br/com/tcs/sws/presenter/pages/" + tela + ".fxml"));
            setUserAgentStylesheet(STYLESHEET_MODENA);
            stage.getIcons().add(new Image("/img/SnkLogo.png"));
            stage.setTitle("Sankhya Workspace Setup");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
