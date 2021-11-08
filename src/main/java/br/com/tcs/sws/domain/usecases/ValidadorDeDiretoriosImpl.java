package br.com.tcs.sws.domain.usecases;

import br.com.tcs.sws.application.usecases.IProcessadorArquivoUseCase;
import br.com.tcs.sws.domain.repositories.IProcessadorArquivoRepository;

public class ValidadorDeDiretoriosImpl implements IProcessadorArquivoUseCase {
	private final IProcessadorArquivoRepository fileValidator;

	public ValidadorDeDiretoriosImpl(IProcessadorArquivoRepository fileValidator) {
		this.fileValidator = fileValidator;
	}

	@Override
	public boolean validaSeDiretorioExiste(String diretorio) {
		return fileValidator.sourceExists(diretorio);
	}

}
