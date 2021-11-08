package br.com.tcs.sws.infrastructure.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class FileUtils {
	public static void zip(String origem, String destino, String senha) {
		try {
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			if (senha.length() > 0) {
				parameters.setEncryptFiles(true);
				parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
				parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
				parameters.setPassword(senha);
			}

			ZipFile zipFile = new ZipFile(destino);

			File targetFile = new File(origem);
			if (targetFile.isFile()) {
				zipFile.addFile(targetFile, parameters);
			} else if (targetFile.isDirectory()) {
				zipFile.addFolder(targetFile, parameters);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String unzip(String origem, String destino, String senha) throws Exception {
		validateFileExists(destino);
		String retorno = "";
		ZipFile zipFile = new ZipFile(origem);
		if (!senha.isEmpty()) {
			if (zipFile.isEncrypted()) {
				zipFile.setPassword(senha);
			}
		}
		zipFile.extractAll(destino);
		List<?> files = zipFile.getFileHeaders();
		retorno = destino + File.separator + files.get(0);
		return retorno;
	}

	public static boolean validateFileExists(String diretorio) {
		File file = new File(diretorio);
		return file.exists();
	}
	
	public static void validateFileExists(String diretorio, boolean createIfNoExists) throws IOException {
        File file = new File(diretorio);
        if (!file.exists() && createIfNoExists) {
            if(file.isFile()) {
            	file.createNewFile();
            }else {
            	file.mkdir();
            }
        }
    }

	public static void writeStringInFile(String conteudo, String diretorio) throws Exception {
		FileWriter fw = new FileWriter(new File(diretorio));
		fw.write(conteudo.replace("\n", "\r\n"));
		fw.flush();
		fw.close();
		System.out.println("Arquivo gravado em: " + diretorio);
	}

	public static void copyFile(String origem, String destino) throws Exception {
		if(origem==null) {
			throw new IllegalStateException("Parâmetro Origem deve ser informado!");
		}else if(origem.trim().isEmpty()){
			throw new IllegalStateException("Parâmetro Origem deve ser informado!");
		}
		
		if(destino==null) {
			throw new IllegalStateException("Parâmetro Destino deve ser informado!");
		}else if(origem.trim().isEmpty()){
			throw new IllegalStateException("Parâmetro Destino deve ser informado!");
		}
		
		Path sourcePath = new File(origem).toPath();
		Path targetPath = new File(destino).toPath();
		Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static String getSize(Long size) {
        String hrSize = "";
        Long k = size;
        Long m = size / 1024 / 1024;
        Long g = size / 1024 / 1024 / 1024;
        Long t = size / 1024 / 1024 / 1024 / 1024;

        if (k > 0) {
            hrSize = new BigDecimal(k).setScale(2, RoundingMode.HALF_UP) + "KB";
        }
        if (m > 0) {

            hrSize = new BigDecimal(m).setScale(2, RoundingMode.HALF_UP) + "MB";
        }
        if (g > 0) {

            hrSize = new BigDecimal(g).setScale(2, RoundingMode.HALF_UP) + "GB";
        }
        if (t > 0) {
            hrSize = new BigDecimal(t).setScale(2, RoundingMode.HALF_UP) + "TB";
        }
        return hrSize;
    }

}
