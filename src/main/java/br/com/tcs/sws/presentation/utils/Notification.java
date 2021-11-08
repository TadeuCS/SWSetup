/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.presentation.utils;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class Notification {

    public void info(String title, String mensagem) {
        if (SystemTray.isSupported()) {
            try {
                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icons/Informacao.png"));
                TrayIcon trayIcon = new TrayIcon(image, title);
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip(title);
                tray.add(trayIcon);
                trayIcon.displayMessage(title, mensagem, TrayIcon.MessageType.INFO);
                tray.remove(trayIcon);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, mensagem, title, JOptionPane.OK_OPTION);
        }
    }

    public void warn(String title, String mensagem) {
        if (SystemTray.isSupported()) {
            try {
                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icons/Informacao.png"));
                TrayIcon trayIcon = new TrayIcon(image, title);
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip(title);
                tray.add(trayIcon);
                trayIcon.displayMessage(title, mensagem, TrayIcon.MessageType.WARNING);
                tray.remove(trayIcon);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, mensagem, title, JOptionPane.OK_OPTION);
        }
    }

    public void error(String title, String mensagem) {
        if (SystemTray.isSupported()) {
            try {
                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icons/Informacao.png"));
                TrayIcon trayIcon = new TrayIcon(image, title);
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip(title);
                tray.add(trayIcon);
                trayIcon.displayMessage(title, mensagem, TrayIcon.MessageType.ERROR);
                tray.remove(trayIcon);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, mensagem, title, JOptionPane.OK_OPTION);
        }
    }

}
