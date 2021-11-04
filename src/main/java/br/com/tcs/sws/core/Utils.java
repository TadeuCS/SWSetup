package br.com.tcs.sws.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 *
 * @author Tadeu-pc
 */
public class Utils {

    public static String formataData(Date data, String formato) {
        try {
            return new SimpleDateFormat(formato).format(data);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getData(Date data) {
        return formataData(data, "dd/MM/yyyy");
    }

    public static String getHora(Date data) {
        return formataData(data, "HH:mm:ss");
    }

    public static String getDataHora(Date data) {
        return formataData(data, "dd/MM/yyyy HH:mm:ss");
    }

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

    public static void validaFile(String diretorio) throws IOException {
        File file = new File(diretorio);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static String unzip(String origem, String destino, String senha) throws Exception {
        validaDiretorioFile(destino);
        String retorno = "";
        ZipFile zipFile = new ZipFile(origem);
        if (!senha.isEmpty()) {
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(senha);
            }
        }
        zipFile.extractAll(destino);
        List<FileHeader> lista = zipFile.getFileHeaders();
        retorno = destino + Sessao.separator + lista.get(0).getFileName();
        return retorno;
    }

    public static String getVersaoSO() {
        Runtime rt = Runtime.getRuntime();
        String versao = "32";
        Scanner s;
        try {
            s = new Scanner(rt.exec(new String[]{"cmd.exe", "/c", "wmic OS get OSArchitecture"}).getInputStream());
            while (s.hasNext()) {
                String linha = s.nextLine();
                versao = linha.replace("bits", "").replace("bit", "").replace("x", "").replace("-", "").trim();
            }
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return versao;
    }

    public static void downloadFromUrl(String dirServidor, String diretorio, String file) throws Exception {
        InputStream is = null;
        FileOutputStream fos = null;
        URLConnection urlConn = new URL(dirServidor).openConnection();//connect

        is = urlConn.getInputStream();               //get connection inputstream
        File dir = new File(diretorio);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println(diretorio + file);
        fos = new FileOutputStream(diretorio + file);   //open outputstream to local file

        byte[] buffer = new byte[4096];              //declare 4KB buffer
        int len;

        //while we have availble data, continue downloading and storing to local file
        while ((len = is.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }
        try {
            if (is != null) {
                is.close();
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
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

    public static String verificaTamanhoArquivo(String dirFile) throws Exception {
        File file = new File(dirFile);
        if (file.exists()) {
            return getSize(file.length());
        } else {
            return "";
        }
    }

    public static void copy(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }
    public static void copy(String sourceLocation, String targetLocation) throws IOException {
        File origem = new File(sourceLocation);
        File destino = new File(targetLocation);
        if (origem.isDirectory()) {
            copyDirectory(origem, destino);
        } else {
            copyFile(origem, destino);
        }
    }

    private static void copyFile(File source, File target) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

    private static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }

    public static void copiaArquivoParaDiretorio(String origem, String destino) throws Exception {
        File arquivoOrigem = new File(origem);
        if (arquivoOrigem.exists()) {
            FileChannel sourceChannel = null;
            FileChannel destinationChannel = null;
            try {
                sourceChannel = new FileInputStream(arquivoOrigem).getChannel();
                destinationChannel = new FileOutputStream(destino).getChannel();
                sourceChannel.transferTo(0, sourceChannel.size(),
                        destinationChannel);
            } finally {
                if (sourceChannel != null && sourceChannel.isOpen()) {
                    sourceChannel.close();
                }
                if (destinationChannel != null && destinationChannel.isOpen()) {
                    destinationChannel.close();
                }
            }
        }
    }

    public static String getMensagemException(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

    public static void escreveLinhasEmArquivo(String conteudo, String diretorio) throws Exception {
        FileWriter fw = new FileWriter(new File(diretorio));
        fw.write(conteudo.replace("\n", "\r\n"));
        fw.flush();
        fw.close();
        System.out.println("Arquivo gravado em: " + diretorio);
    }

    public static void baixaArquivo(String dirCliente, String fileName) throws Exception {
        if (!new File(dirCliente + fileName).exists()) {
//            iptLog.appendText(getHora(new Date()) + " - Baixando o arquivo " + fileName + " ...\n");
//            try {
//                Utils.downloadFromUrl("http://metre.ddns.net:88/Instaladores/" + fileName, dirCliente, fileName);
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new Exception("Erro ao fazer download do arquivo " + fileName + "!");
//            }
//            String tamanho = Utils.verificaTamanhoArquivo(dirCliente + fileName);
//            iptLog.appendText(getHora(new Date()) + " - Fim do download do arquivo " + fileName + "\n\n");
        }
    }

    public static void extrairPastas(String origem, String destino) throws Exception {
//        String filename = new File(origem).getName();
//        try {
//            iptLog.appendText(getHora(new Date()) + " - Extraindo " + filename + "...\n");
//            Utils.unzip(origem, destino, "");
//            iptLog.appendText(getHora(new Date()) + " - " + filename + " extraído com sucesso!\n\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Erro ao extrair o arquivo " + filename + "!");
//        }
    }

    public static void testaMySQL() throws Exception {
//        try {
//            iptLog.appendText(getHora(new Date()) + " - Testando Serviço ...\n");
//            if (Conexao.getConnection() == null) {
//                iptLog.appendText(getHora(new Date()) + " - Conexão não estabelecida!\n");
//            } else {
//                iptLog.appendText(getHora(new Date()) + " - Conexão estabelecida com sucesso!\n\n");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Erro ao Testar o Serviço do MySQL!");
//        }
    }

    public static void salvaINI() throws Exception {
//        String caminho = DIR_CHEF + "Default.ini";
//        validaFile(caminho);
//        ini = new Ini(new File(caminho));
//        ini.put("Configuracao", "dirChef", DIR_CHEF);
//        ini.put("Configuracao", "dirMySQL", DIR_MYSQL);
//        ini.put("Configuracao", "dirPayara", DIR_PAYARA);
//        ini.store();
    }

    public static void downloadPathByURL(String urlServidor, String diretorioCliente) throws Exception {
//        Document doc = Jsoup.connect(urlServidor).get();
//        validaDiretorioFile(diretorioCliente);
//        for (Element file : doc.select("tbody tr td a")) {
//            String fileName = file.attr("href");
//            if (!fileName.contains("/AutoUpdate/Versao/") && !new File(diretorioCliente + fileName.replace("%20", " ")).exists()) {
//                System.out.println("Baixando: " + fileName.replace("%20", " "));
//                try {
//                    downloadFileByURL(urlServidor + fileName, diretorioCliente, fileName.replace("%20", " "));
//                } catch (Exception e) {
//                    throw new Exception("Erro ao fazer download do arquivo " + fileName);
//                }
//            }
//        }
    }

    /**
     * Constutor padrao.
     */
    public static void downloadFileByURL(String dirServidor, String diretorio, String file) throws IOException {
        InputStream is = null;
        FileOutputStream fos = null;
        URLConnection urlConn = new URL(dirServidor).openConnection();//connect

        is = urlConn.getInputStream();               //get connection inputstream
        File dir = new File(diretorio);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        fos = new FileOutputStream(diretorio + "\\" + file);   //open outputstream to local file

        byte[] buffer = new byte[4096];              //declare 4KB buffer
        int len;

        //while we have availble data, continue downloading and storing to local file
        while ((len = is.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }
        try {
            if (is != null) {
                is.close();
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void validaDiretorioFile(String diretorio) {
        File file = new File(diretorio);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
