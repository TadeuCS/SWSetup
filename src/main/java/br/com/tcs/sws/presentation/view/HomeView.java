package br.com.tcs.sws.presentation.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.application.controllers.ParametroController;
import br.com.tcs.sws.presentation.facade.StageFacade;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class HomeView extends StageFacade implements Initializable {

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ParametroController controller = new ParametroController();
		controller.carregaParametros();
	}

}
