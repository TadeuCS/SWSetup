package br.com.tcs.sws.presentation.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.application.usecases.ValidadorDeDiretoriosImpl;
import br.com.tcs.sws.presentation.facade.StageFacade;
import br.com.tcs.sws.presentation.usecases.IProcessadorArquivoUseCase;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class HomeController extends StageFacade implements Initializable {

	private IProcessadorArquivoUseCase validadorDeDiretorios;
	
	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
    @Override
	public void initialize(URL url, ResourceBundle rb) {
		String diretorio="C:\\Users\\Tadeu-PC\\Desktop\\Nova pasta\\";
		this.validadorDeDiretorios = new ValidadorDeDiretoriosImpl(null);
//		boolean existe = validadorDeDiretorios.validaSeDiretorioExiste(diretorio);
//		System.out.println(existe);
	}

}
