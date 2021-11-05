package br.com.tcs.sws;

import br.com.tcs.sws.core.ScreenUtils;
import br.com.tcs.sws.core.Sessao;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Sessao.screenUtils = new ScreenUtils(stage);
        Sessao.screenUtils.addTelaNaLista("HomePage");
        Sessao.screenUtils.addTelaNaLista("DirectoryPage");
        Sessao.screenUtils.addTelaNaLista("OptionsPage");
        Sessao.screenUtils.addTelaNaLista("ExecutionPage");
        Sessao.screenUtils.addTelaNaLista("FinallyPage");
        Sessao.screenUtils.addTelaNaLista("LogPage");
        Sessao.screenUtils.moveTo(0);
    }
}
