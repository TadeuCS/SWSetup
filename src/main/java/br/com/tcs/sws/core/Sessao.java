/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.core;

import org.ini4j.Ini;

import javafx.scene.control.TextArea;

/**
 *
 * @author Tadeu-pc
 */
public class Sessao {

    public static final String separator = System.getProperty("file.separator");
    public static final String URL_METRE_GESTAO = "http://metre.ddns.net/MetreGestao/webresources/WS/";
    public static final String URL_VERSOES_SERVIDOR = "http://metre.ddns.net:88/AutoUpdate/Versao/";

    public static String DIR_CHEF;
    public static String DIR_MYSQL;
    public static String DIR_PAYARA;
    public static String DIR_INSTALADORES;
    
    public static String tipoTerminal; //S = ipServidor, E = Estação
    public static String versaoSO; //32, 64
    public static String sistemaOperacional; //Windows, Linux
    public static String ipServidor; //192.168.1.100, TADEU-PC
    public static Integer versaoOficial;
    
    public static Ini ini;
    public static Tela tela;
    public static TextArea iptLog;

}
