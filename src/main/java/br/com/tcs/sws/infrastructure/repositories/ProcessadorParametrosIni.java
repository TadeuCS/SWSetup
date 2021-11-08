package br.com.tcs.sws.infrastructure.repositories;

import java.util.Arrays;

import br.com.tcs.sws.domain.repositories.IProcessadorParametrosRepository;
import br.com.tcs.sws.infrastructure.models.ParamettersFileModel;

public class ProcessadorParametrosIni implements IProcessadorParametrosRepository{

	@Override
	public ParamettersFileModel buscaParametros(String caminhoArquivo) {
		return new ParamettersFileModel("192.168.1.187", "\\java\\JAVA\\Backup -Tadeu\\", Arrays.asList("WORKSPACE", "ECLIPSE", "JBOSS"));
	}
	
}
