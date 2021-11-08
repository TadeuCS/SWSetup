package br.com.tcs.sws.presentation.facade;

import br.com.tcs.sws.presentation.utils.Mensagem;
import br.com.tcs.sws.presentation.utils.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author Tadeu-pc
 */
public abstract class StageFacade{
	@FXML
	protected void onNext(ActionEvent event) {
		StageUtils.getInstance().moveToNextPage();
	}

	@FXML
	protected void onBack(ActionEvent event) {
		StageUtils.getInstance().moveToBackPage();
	}
	
	@FXML
	protected void onCancel(ActionEvent event) {
		if (Mensagem.mensagemConfirm("Deseja cancelar a instalação?")) {
			System.exit(0);
		}
	}
}
