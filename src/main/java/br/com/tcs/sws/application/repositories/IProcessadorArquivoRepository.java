package br.com.tcs.sws.application.repositories;

public interface IProcessadorArquivoRepository {
	public boolean fileExists(String path, String fileName);
	public boolean sourceExists(String path);
}
