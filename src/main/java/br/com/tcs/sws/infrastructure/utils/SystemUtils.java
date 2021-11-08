package br.com.tcs.sws.infrastructure.utils;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemUtils {
	public static String getVersaoSO() {
		Runtime rt = Runtime.getRuntime();
		String versao = "32";
		Scanner s;
		try {
			s = new Scanner(rt.exec(new String[] { "cmd.exe", "/c", "wmic OS get OSArchitecture" }).getInputStream());
			while (s.hasNext()) {
				String linha = s.nextLine();
				versao = linha.replace("bits", "").replace("bit", "").replace("x", "").replace("-", "").trim();
			}
		} catch (IOException ex) {
			Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		return versao;
	}
}
