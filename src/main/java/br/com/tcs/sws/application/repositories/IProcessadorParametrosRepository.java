package br.com.tcs.sws.application.repositories;

import br.com.tcs.sws.domain.files.ParamettersFile;

public interface IProcessadorParametrosRepository {
	public ParamettersFile buscaParametros(String caminhoArquivo);
}
