package View;

import Controller.userControl;
import Controller.userList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class findContact extends Tab {

    private final userControl controllingUser;
    private final userList listUser;

    public findContact(){

        GridPane grid = new GridPane();
        controllingUser = new userControl();
        listUser = new userList();

        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);

        setText("Finding Contacts");

        Label sceneLabel = new Label("Finding contacts in database");
        grid.add(sceneLabel, 1, 1);

        Label welcomeLabel = new Label("Enter the name of the person you wish to find");
        grid.add(welcomeLabel, 1, 2);

        TextField name_Text = new TextField();
        name_Text.setEditable(true);
        grid.add(name_Text, 2, 2);

        Button searchName_btn = new Button("Search for user (Name)");
        HBox searchName_hbtn = new HBox(1);
        searchName_hbtn.getChildren().add(searchName_btn);
        grid.add(searchName_hbtn, 1, 3);

        Label idLabel = new Label("Enter the id of the person you wish to find");
        grid.add(idLabel, 1, 4);

        TextField id_Text = new TextField();
        id_Text.setEditable(true);
        grid.add(id_Text, 2, 4);

        Button searchId_btn = new Button("Search for user (ID)");
        HBox searchId_hbtn = new HBox(1);
        searchId_hbtn.getChildren().add(searchId_btn);
        grid.add(searchId_hbtn, 1, 5);

        TextArea text_area = new TextArea();
        text_area.setEditable(false);
        double height = 100;
        double width = 300;
        text_area.setPrefHeight(height);
        text_area.setPrefWidth(width);
        grid.add(text_area, 1, 7);

        searchName_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = controllingUser.searchUserName(name_Text.getText());
                name_Text.clear();
                text_area.setText(result);
            }
        });

        searchId_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = controllingUser.searchUserId(Integer.parseInt(id_Text.getText()));
                id_Text.clear();
                text_area.setText(result);
            }
        });
        setContent(grid);
    }
}
