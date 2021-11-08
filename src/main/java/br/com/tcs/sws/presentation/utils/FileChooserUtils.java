/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.presentation.utils;

import java.io.File;
import java.util.List;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

/**
 *
 * @author Tadeu-PC
 */
public class FileChooserUtils {
    public static String getFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione um arquivo");
//        fileChooser.setInitialDirectory(new File(SessaoUtils.DIRETORIO_CHEF));
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();
        } else {
            return "";
        }
    }
    public static String getFile(List<String> extensoes) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione um arquivo");
//        fileChooser.setInitialDirectory(new File(SessaoUtils.DIRETORIO_CHEF));
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Arquivos", extensoes));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();
        } else {
            return "";
        }
    }

    public static String getDiretory() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Selecione um Diretório");
//        chooser.setInitialDirectory(new File(SessaoUtils.DIRETORIO_CHEF));
        File selectedFile = chooser.showDialog(null);
        if (selectedFile != null) {
            return selectedFile.getAbsolutePath() + File.separator;
        } else {
            return "";
        }
    }
}
