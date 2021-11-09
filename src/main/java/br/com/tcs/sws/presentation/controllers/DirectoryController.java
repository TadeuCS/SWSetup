package br.com.tcs.sws.presentation.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.presentation.facade.StageFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class DirectoryController extends StageFacade implements Initializable{

    @FXML
    private Button btnFolderSearch;
    @FXML
    private TextField iptDiretorioSistema;
    @FXML
    private Button btnProximo;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	iptDiretorioSistema.setEditable(false);
    	btnFolderSearch.setDisable(true);
    	btnProximo.disableProperty().bind(iptDiretorioSistema.textProperty().isEmpty());
	}

    @FXML
    private void buscarDirSistema(ActionEvent event) {
    }

}
