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
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class OptionsController implements Initializable {

    @FXML
    private CheckBox chxEclipse;
    @FXML
    private CheckBox chxProjetos;
    @FXML
    private CheckBox chxJboss;
    @FXML
    private CheckBox chxDwf;
    @FXML
    private CheckBox chxPscript;
    @FXML
    private CheckBox chxGerenciadorDePacotes;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
//    @Override
	public void initialize(URL url, ResourceBundle rb) {
//        Sessao.sistemaOperacional=System.getProperty("os.name");
	}

	@FXML
	private void anterior(ActionEvent event) {
		Sessao.screenUtils.moveToBackPage();
	}

	@FXML
	private void instalar(ActionEvent event) {
		Sessao.screenUtils.moveToNextPage();
	}

	@FXML
	private void cancelar(ActionEvent event) {
		if (Mensagem.mensagemConfirm("Deseja cancelar a instala��o?")) {
			System.exit(0);
		}
	}

}
