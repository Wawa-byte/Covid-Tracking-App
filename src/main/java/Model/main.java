// Waleed Akhtar
package Model;

import View.addingContacts;
import View.findContact;
import View.positiveCovid;
import View.timeandDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            BorderPane border = new BorderPane();
            TabPane tabs = new TabPane();

            // Adding tabs
            tabs.getTabs().add(new addingContacts());
            tabs.getTabs().add(new findContact());
            tabs.getTabs().add(new timeandDate());
            tabs.getTabs().add(new positiveCovid());

            border.setCenter(tabs);
            Scene scene = new Scene(border, 500, 500);

            primaryStage.setTitle("Covid Measuring App");
            primaryStage.getIcons().add(new Image("file:covid.jpg")); // Image for application
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
