package br.com.tcs.sws.infrastructure.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileUtilsTest {
	private String origem;
	private String destino;
	@BeforeEach
	void setUp() throws Exception {
		origem = null;
		destino = null;
	}

	@Test
	void DeveriaBaixarArquivo() {
		String fileName = "pix-client.rar";
		origem = "\\\\192.168.1.187\\java\\JAVA\\Backup -Tadeu\\"+fileName; 
		destino = "C:\\Users\\Tadeu-PC\\Desktop\\Nova pasta\\"+fileName; 
		assertDoesNotThrow(()->FileUtils.copyFile(origem, destino));
	}
	
	@Test
	void DeveriaDarErroAoBaixarArquivoPassandoDiretorioDeOrigemNull() {
		assertThrows(Exception.class, ()-> FileUtils.copyFile(origem, destino));
	}
	
	@Test
	void DeveriaDarErroAoBaixarArquivoPassandoDiretorioDeDestinoNull() {
		assertThrows(Exception.class, ()-> FileUtils.copyFile(origem, destino));
	}
	
	@Test
	void DeveriaDarErroAoBaixarArquivoPassandoDiretorioDeOrigemVazio() {
		origem = "";
		destino = "";
		assertThrows(Exception.class, ()-> FileUtils.copyFile(origem, destino));
	}
	
	@Test
	void DeveriaDarErroAoBaixarArquivoPassandoDiretorioDeDestinoVazio() {
		origem = "";
		destino = "";
		assertThrows(Exception.class, ()-> FileUtils.copyFile(origem, destino));
	}

}
