package application;

import javafx.application.Preloader;
import javafx.stage.Stage;

import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MainPreloader extends Preloader {
	ProgressBar bar;
    Stage stage;
 
    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        return new Scene(p, 300, 150);        
    }
    
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());        
        stage.show();
    }
    
    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	bar.setProgress(pn.getProgress());
    }
 
    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }    
}