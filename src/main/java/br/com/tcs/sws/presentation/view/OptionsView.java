package br.com.tcs.sws.presentation.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.presentation.facade.StageFacade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class OptionsView  extends StageFacade implements Initializable {

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
    @FXML
    private Button btnInstalar;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	selecionaOpcoesDefault();
    	btnInstalar.disableProperty().bind(chxEclipse.selectedProperty().not()
    			.and(chxProjetos.selectedProperty().not())
    			. and(chxJboss.selectedProperty().not())
    			. and(chxDwf.selectedProperty().not())
    			. and(chxPscript.selectedProperty().not())
    			. and(chxGerenciadorDePacotes.selectedProperty().not())
    			);
	}

	private void selecionaOpcoesDefault() {
		chxEclipse.setSelected(true);
		chxProjetos.setSelected(true);
		chxJboss.setSelected(true);
	}

}
