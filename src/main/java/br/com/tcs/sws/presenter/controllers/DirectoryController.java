/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.presenter.controllers;

//import com.metre.mi.util.Mensagem;
//import com.metre.mi.util.Sessao;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.core.Mensagem;
import br.com.tcs.sws.core.Sessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class DirectoryController implements Initializable {

    @FXML
    private VBox vBoxCaminhoBackup1;
    @FXML
    private TextField iptDiretorioSistema;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
//    @Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	@FXML
	private void proximo(ActionEvent event) {
		Sessao.screenUtils.moveToNextPage();
	}

	@FXML
	private void anterior(ActionEvent event) {
		Sessao.screenUtils.moveToBackPage();
	}

	@FXML
	private void buscarDirSistema(ActionEvent event) {
	}

	@FXML
	private void cancelar(ActionEvent event) {
		if (Mensagem.mensagemConfirm("Deseja cancelar a instalação?")) {
			System.exit(0);
		}
	}

}
