/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author Tadeu-PC
 */
public final class LogUtils {

    public static void error(Exception e, String diretorio) {
        StringBuilder sb = new StringBuilder();
        String erro = getMensagemException(e);
        sb.append(erro).append("\r\n");
        geraLog(diretorio, sb.toString());
    }

    public static void error(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDateFormatada("dd/MM/yyyy HH:mm:ss")).append(" - ");
        sb.append(getNomePCLogado()).append("/");
        sb.append(getIpPCLogado()).append("\r\n");
        String erro = getMensagemException(e);
        System.err.println(erro);
        sb.append(erro).append("\r\n");
        geraLog(sb.toString());
    }

    public static void errorOnly(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDateFormatada("dd/MM/yyyy HH:mm:ss")).append(" - ");
        sb.append(getNomePCLogado()).append("/");
        sb.append(getIpPCLogado()).append("\r\n");
        String erro = getMensagemException(e);
        sb.append(erro).append("\r\n");
        geraLog(sb.toString());
    }

    public static void error(String e) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDateFormatada("dd/MM/yyyy HH:mm:ss")).append(" - ");
        sb.append(getNomePCLogado()).append("/");
        sb.append(getIpPCLogado()).append("\r\n");
        String erro = e;
        System.err.println(erro);
        sb.append(erro).append("\r\n");
        geraLog(sb.toString());
    }

    public static void errorOnlyFile(String e) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDateFormatada("dd/MM/yyyy HH:mm:ss")).append(" - ");
        sb.append(getNomePCLogado()).append("/");
        sb.append(getIpPCLogado()).append("\r\n");
        sb.append(e).append("\r\n");
        geraLog(sb.toString());
    }

    public static void infoOnlyFile(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDateFormatada("dd/MM/yyyy HH:mm:ss")).append(" - ").append(msg).append("\r\n");
        geraLog(sb.toString());
    }

    public static void info(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDateFormatada("dd/MM/yyyy HH:mm:ss")).append(" - ");
        sb.append(getNomePCLogado()).append("/");
        sb.append(getIpPCLogado()).append("\r\n");
        sb.append(msg).append("\r\n").append("\r\n");
        geraLog(sb.toString());
    }

    private static String getNomePCLogado() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            byte[] ipAddr = addr.getAddress();
            return addr.getHostName();
        } catch (UnknownHostException ex) {
            java.util.logging.Logger.getLogger(LogUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static String getIpPCLogado() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            byte[] ipAddr = addr.getAddress();
            return addr.getHostAddress();
        } catch (UnknownHostException ex) {
            java.util.logging.Logger.getLogger(LogUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static String getMensagemException(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
//        System.out.println(sw.toString());
        return sw.toString();
    }

    private static void geraLog(String linhas) {
        try {
            FileWriter fw = new FileWriter(gerArquivoLog(), true);
            fw.write(linhas);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void geraLog(String diretorio, String linhas) {
        try {
            FileWriter fw = new FileWriter(new File(diretorio), true);
            fw.write(linhas);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getDateFormatada(String formato) {
        SimpleDateFormat fmt = new SimpleDateFormat(formato);
        return fmt.format(new Date());
    }

    private static File gerArquivoLog() throws IOException {
//        String diretorio = "C:/Chef/Logs/"; //pasta onde será salvo o arquivo .log
//        String nomeArquivo = getDateFormatada("ddMMyyyy") + ".log"; //nome do arquivo .log que será gerado.
//        String nomeArquivo = getDateFormatada("ddMMyyyy") + ".log"; //nome do arquivo .log que será gerado.
        String diretorio = Sessao.DIR_CHEF + "Logs" + Sessao.separator;
        File dir = new File(diretorio);
        File dirFile = new File(diretorio + "update.log");
        if (!dir.exists()) {
            dir.mkdir();
        } else if (!dirFile.exists()) {
            dirFile.createNewFile();
        }
        return dirFile;
    }
}
