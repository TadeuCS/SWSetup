package br.com.tcs.sws.domain.usecases;

import br.com.tcs.sws.application.usecases.IProcessadorParametrosUseCase;
import br.com.tcs.sws.domain.repositories.IProcessadorParametrosRepository;
import br.com.tcs.sws.domain.utils.SessionUtils;

public class ProcessadorDeParametrosImpl implements IProcessadorParametrosUseCase{
	private final IProcessadorParametrosRepository processadorParametro;
	public ProcessadorDeParametrosImpl(IProcessadorParametrosRepository processadorParametro) {
		this.processadorParametro = processadorParametro;
	}
	@Override
	public void carregaParametros() {
		SessionUtils.parametters = processadorParametro.buscaParametros("C:\\");
		System.out.println("Carregou!");
	}
	
}
