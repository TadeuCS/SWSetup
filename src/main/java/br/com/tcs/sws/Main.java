package br.com.tcs.sws;

import br.com.tcs.sws.core.Sessao;
import br.com.tcs.sws.core.Tela;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Sessao.tela = new Tela(stage);
        Sessao.tela.moveTo("HomePage");
    }
}
