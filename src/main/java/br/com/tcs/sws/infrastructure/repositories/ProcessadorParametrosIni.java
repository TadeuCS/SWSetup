package br.com.tcs.sws.infrastructure.repositories;

import br.com.tcs.sws.application.repositories.IProcessadorParametrosRepository;
import br.com.tcs.sws.domain.files.ParamettersFile;

public class ProcessadorParametrosIni implements IProcessadorParametrosRepository{

	@Override
	public ParamettersFile buscaParametros(String caminhoArquivo) {
		return null;
	}
	
}
