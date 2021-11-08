package br.com.tcs.sws.infrastructure.models;

import java.util.List;

import br.com.tcs.sws.domain.entities.ParamettersFile;

public class ParamettersFileModel extends ParamettersFile{

	public ParamettersFileModel(String ip, String diretorio, List<String> opcoes) {
		super(ip, diretorio, opcoes);
	}

}
