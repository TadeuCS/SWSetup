package br.com.tcs.sws.application.controllers;

import br.com.tcs.sws.application.usecases.IProcessadorParametrosUseCase;
import br.com.tcs.sws.domain.repositories.IProcessadorParametrosRepository;
import br.com.tcs.sws.domain.usecases.ProcessadorDeParametrosImpl;
import br.com.tcs.sws.infrastructure.repositories.ProcessadorParametrosIni;

public class ParametroController {
	private final IProcessadorParametrosRepository respository = new ProcessadorParametrosIni();
	private final IProcessadorParametrosUseCase usecase = new ProcessadorDeParametrosImpl(respository);

	public void carregaParametros() {
		usecase.carregaParametros();
	}
}
