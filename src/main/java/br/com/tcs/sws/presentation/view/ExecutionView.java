package br.com.tcs.sws.presentation.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.presentation.facade.StageFacade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class ExecutionView  extends StageFacade implements Initializable {

    @FXML
    private TextArea iptLog;
    @FXML
    private ProgressBar progress;
    @FXML
    private Button btnCancelar;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	//Inicia processamento...
	}

}
