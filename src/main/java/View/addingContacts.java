package View;

import Controller.userControl;
import Controller.userList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.Optional;

public class addingContacts extends Tab {

    private final userControl controllingUser;
    private final userList listUser;

    public addingContacts() {

        GridPane grid = new GridPane();

        setText("Add Contacts");

        controllingUser = new userControl();
        listUser = new userList();

        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);

        // i is width across
        // i1 is Height

        Label sceneLabel = new Label("Contacts");
        grid.add(sceneLabel, 1, 1);


        Label fName = new Label("Enter your First Name");
        grid.add(fName, 1, 2);

        TextField fName_Text = new TextField(); // Source of the action event
        fName_Text.setEditable(true); // User can edit this field
        grid.add(fName_Text, 2, 2);

        Label mName = new Label("Enter your Middle Name");
        grid.add(mName, 1, 3);

        TextField mName_Text = new TextField();
        mName_Text.setEditable(true);
        grid.add(mName_Text, 2, 3);

        Label lName = new Label("Enter Last Name");
        grid.add(lName, 1, 4);

        TextField fLast_Text = new TextField();
        fName_Text.setEditable(true);
        grid.add(fLast_Text, 2, 4);

        Label uniqueID = new Label("Enter the Unique ID");
        grid.add(uniqueID,1, 5);

        TextField uniqueID_Text = new TextField();
        fName_Text.setEditable(true);
        grid.add(uniqueID_Text, 2, 5);

        Label phoneNo = new Label("Enter the Phone Number");
        grid.add(phoneNo, 1, 6);

        TextField phoneNo_Text = new TextField();
        fName_Text.setEditable(true);
        grid.add(phoneNo_Text, 2, 6);

        Label email = new Label("Enter your Email Address");
        grid.add(email, 1, 7);

        TextField email_text = new TextField();
        email_text.setEditable(true);
        grid.add(email_text, 2, 7);

        Button add_btn = new Button("Add");
        HBox add_hbtn = new HBox(1);
        add_hbtn.getChildren().add(add_btn);
        grid.add(add_hbtn, 1, 8);

        Button remove_btn = new Button("Remove");
        HBox remove_hbtn = new HBox(1);
        remove_hbtn.getChildren().add(remove_btn);
        grid.add(remove_hbtn, 2, 8);

        Button list_btn = new Button("List");
        HBox list_hbtn = new HBox(1);
        list_hbtn.getChildren().add(list_btn);
        grid.add(list_hbtn, 3,8);

        TextArea text_area = new TextArea();
        text_area.setEditable(false); // Users cannot edit the Text Area
        double height = 100;
        double width = 200;
        text_area.setPrefHeight(height);
        text_area.setPrefWidth(width);
        grid.add(text_area, 1, 11);

        Button load_btn = new Button("Load");
        HBox load_hbtn = new HBox(1);
        load_hbtn.getChildren().add(load_btn);
        grid.add(load_hbtn, 1, 13);

        Button save_btn = new Button("Save");
        HBox save_hbtn = new HBox(1);
        save_hbtn.getChildren().add(save_btn);
        grid.add(save_hbtn, 2, 13);

        Button exit_btn = new Button("Exit");
        HBox exit_hbtn = new HBox(1);
        exit_hbtn.getChildren().add(exit_btn);
        grid.add(exit_hbtn, 3, 13);

        // Add button action events
        add_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controllingUser.addingUser(fName_Text.getText(), mName_Text.getText(), fLast_Text.getText(), uniqueID_Text.getText(), phoneNo_Text.getText(), email_text.getText());
                fName_Text.clear();
                mName_Text.clear();
                fLast_Text.clear();
                uniqueID_Text.clear();
                phoneNo_Text.clear();
                email_text.clear();
            }
        });

        // List button
        list_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text_area.setText(controllingUser.findAll());
            }
        });

        // Save button
        save_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                listUser.saveList();
            }
        });

        // Delete button
        remove_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TextInputDialog delete_box = new TextInputDialog(); // Using dialogue box
                delete_box.setTitle("Delete User");
                delete_box.getDialogPane().setContentText("Enter User ID:"); // Set the label at the side
                Optional<String> delete_text = delete_box.showAndWait(); // Gets the input from user
                controllingUser.removeUser(Integer.parseInt(delete_text.get()));
                controllingUser.removeUserClose(Integer.parseInt(delete_text.get()));
            }
        });

        // Load button events
        load_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text_area.setText(listUser.loadList());
            }
        });

        // Exit button
        exit_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                confirmation.setTitle("Save confirmation");
                confirmation.setContentText("Would you like to save the file or not?");

                ButtonType yesBtn = new ButtonType("Yes");
                ButtonType noBtn = new ButtonType("No");

                confirmation.getButtonTypes().setAll(yesBtn, noBtn);
                Optional<ButtonType> responce = confirmation.showAndWait();

                if (responce.get() == yesBtn){
                    listUser.saveList();
                    Platform.exit(); // Closes the application
                }
                else if (responce.get() == noBtn){
                    Platform.exit(); // CLoses the application without saving the file
                }
            }
        });
        setContent(grid);
    }
}
