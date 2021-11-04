/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.presenter.controllers;

//import com.metre.mi.util.Mensagem;
//import com.metre.mi.util.Sessao;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.tcs.sws.core.Mensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Tadeu-pc
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
//    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Sessao.sistemaOperacional=System.getProperty("os.name");
    }    

    @FXML
    private void proximo(ActionEvent event) {
//        Sessao.tela.moveTo("TipoInstalacaoFXML");
    }

    @FXML
    private void cancelar(ActionEvent event) {
        if(Mensagem.mensagemConfirm("Deseja cancelar a instalação?")){
            System.exit(0);
        }
    }
    
}
