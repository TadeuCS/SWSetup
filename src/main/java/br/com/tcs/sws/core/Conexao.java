/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.core;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tadeu-pc
 */
public class Conexao {

    public static Connection getConnection() {
        try {
//            Class.forName("com.mysql.jdbc.Driver"); //Altere o Driver caso não seja o MySQL   
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/mysql?useTimezone=true&serverTimezone=UTC", "metre", "durama@357");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
