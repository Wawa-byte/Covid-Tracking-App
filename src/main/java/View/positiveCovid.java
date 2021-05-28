package View;

import Controller.userControl;
import Controller.userList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


import java.util.Optional;

public class positiveCovid extends Tab {

    private final userControl controllingUser;
    private final userList listUser;

    public positiveCovid(){

        GridPane grid = new GridPane();
        controllingUser = new userControl();
        listUser = new userList();

        setText("Positive COVID Contact");

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);

        Label welcomeLabel = new Label("Positive covid contacts you have had with people");
        grid.add(welcomeLabel, 1, 1);

        Label display_info = new Label("Display Close contacts");
        grid.add(display_info, 1,2);

        Button display_btn = new Button("Display contacts in order of ID");
        HBox display_hbtn = new HBox(1);
        display_hbtn.getChildren().add(display_btn);
        grid.add(display_hbtn, 1, 3);

        Button displayDate_btn = new Button("Display contacts from a certain date");
        HBox displayDate_hbtn = new HBox(1);
        displayDate_hbtn.getChildren().add(displayDate_btn);
        grid.add(displayDate_hbtn, 1, 4);

        DatePicker datePicker = new DatePicker();
        grid.add(datePicker, 2, 4);

        TextArea text_area = new TextArea();
        text_area.setEditable(false);
        double height = 100;
        double width = 400;
        text_area.setPrefHeight(height);
        text_area.setPrefWidth(width);
        grid.add(text_area, 1, 7);

        // Show all contacts via ID
        display_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String load_user = controllingUser.findContact();
                text_area.setText(load_user);
            }
        });

        // Show contacts from a certain date
        displayDate_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TextInputDialog findUser_box = new TextInputDialog(); // Using dialogue box
                findUser_box.setTitle("Find User via ID");
                findUser_box.getDialogPane().setContentText("Enter User ID:"); // Set the label at the side
                Optional<String> user_ID = findUser_box.showAndWait(); // Gets the input from user
                controllingUser.orderDate(Integer.parseInt(user_ID.get()), datePicker.getValue());
            }
        });

        setContent(grid);
    }
}
