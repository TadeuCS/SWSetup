/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.presentation.utils;

import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.setUserAgentStylesheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class StageUtils {

	public Stage stage;
	public Screen screen;
	public Parent root;

	private String currentPage = "";

	public final List<String> telas = new ArrayList<>();
	
	private static final StageUtils instance = new StageUtils();

    private StageUtils() {}

    public static StageUtils getInstance() {
        return instance; 
    }

	public void init(Stage stage) {
		this.stage = stage;
		this.screen = Screen.getPrimary();
		addTelaNaLista("HomePage");
        addTelaNaLista("DirectoryPage");
        addTelaNaLista("OptionsPage");
        addTelaNaLista("ExecutionPage");
        addTelaNaLista("FinallyPage");
        addTelaNaLista("LogPage");
        moveTo(0);
	}

	public void addTelaNaLista(String tela) {
		this.telas.add(tela);
	}

	public void addTelaNaLista(Class<?> tela) {
		this.telas.add(tela.getSimpleName());
	}

	public void moveToNextPage() {
		int currentIndex = telas.indexOf(currentPage);
		if (currentIndex == telas.size() - 1) {
			return;
		}
		String newScreen = telas.get(currentIndex + 1);
		moveTo(newScreen);
	}

	public void moveToBackPage() {
		int currentIndex = telas.indexOf(currentPage);
		if (currentIndex == 0) {
			return;
		}
		String newScreen = telas.get(currentIndex - 1);
		moveTo(newScreen);
	}

	public void moveTo(int index) {
		moveTo(telas.get(index));
	}

	public void moveTo(String tela) {
		try {
			root = FXMLLoader.load(getClass().getResource("/br/com/tcs/sws/presentation/pages/" + tela + ".fxml"));
			setUserAgentStylesheet(STYLESHEET_MODENA);
            stage.getIcons().add(new Image("/img/Logo.png"));
			stage.setTitle("Sankhya Workspace Setup");
			stage.setResizable(false);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			this.currentPage = tela;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.gc();
		}
	}

}
