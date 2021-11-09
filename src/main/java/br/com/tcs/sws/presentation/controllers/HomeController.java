package br.com.tcs.sws.presentation.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.domain.repositories.IProcessadorParametrosRepository;
import br.com.tcs.sws.domain.usecases.ProcessadorDeParametrosImpl;
import br.com.tcs.sws.infrastructure.repositories.ProcessadorParametrosIni;
import br.com.tcs.sws.presentation.facade.StageFacade;
import br.com.tcs.sws.presentation.usecases.IProcessadorParametrosUseCase;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class HomeController extends StageFacade implements Initializable {

	private final IProcessadorParametrosRepository respository = new ProcessadorParametrosIni();
	private final IProcessadorParametrosUseCase usecase = new ProcessadorDeParametrosImpl(respository);
	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		usecase.carregaParametros();
	}

}
