package br.com.tcs.sws.domain.repositories;

import br.com.tcs.sws.domain.entities.ParamettersFile;

public interface IProcessadorParametrosRepository {
	public ParamettersFile buscaParametros(String caminhoArquivo);
}
