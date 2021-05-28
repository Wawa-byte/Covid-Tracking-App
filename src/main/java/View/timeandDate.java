package View;

import Controller.userControl;
import Controller.userList;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.beans.value.ChangeListener;

public class timeandDate extends Tab {

    private final userControl controllingUser;
    private final userList listUser;
    private String person;
    private String person2;

    public timeandDate(){

        GridPane grid = new GridPane();
        controllingUser = new userControl();
        listUser = new userList();
        ComboBox dropDownBox1 = new ComboBox();
        ComboBox dropDownBox2 = new ComboBox();

        setText("Date and Time");

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);

        Label load = new Label("Please press the load button to get contact information");
        grid.add(load, 1, 1);

        Button load_btn = new Button("Load contact");
        HBox load_hbtn = new HBox(1);
        load_hbtn.getChildren().add(load_btn);
        grid.add(load_hbtn, 2, 1);

        Label welcomeLabel = new Label("Record Close Contact with a person");
        grid.add(welcomeLabel, 1, 2);
        grid.add(dropDownBox1, 1, 3);
        grid.add(dropDownBox2, 1, 4);

        Label dateLabel = new Label("Date met:");
        grid.add(dateLabel, 1, 5);

        DatePicker datePicker = new DatePicker();
        grid.add(datePicker, 2, 5);

        Label timeLabel = new Label("Time met:");
        grid.add(timeLabel, 1,6);

        TextField timeText = new TextField();
        timeText.setEditable(true);
        grid.add(timeText, 2, 6);

        Button add_btn = new Button("Add information");
        HBox add_hbtn = new HBox(1);
        add_hbtn.getChildren().add(add_btn);
        grid.add(add_hbtn, 1, 7);

        // Add in the date and time of close contact
        add_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dropDownBox1.valueProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue observableValue, String oldValue, String newValue) {
                        person = newValue;
                        String[] id = person.split(" ");
                        String person1ID = id[5];
                        System.out.println(person1ID);
                    }
                });

                dropDownBox2.valueProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue observableValue, String oldValue, String newValue) {
                        person2 = newValue;
                        String[] id2 = person2.split(" ");
                        String person2ID = id2[5];
                        System.out.println(person2ID);
                    }
                });

                controllingUser.closeContact(dropDownBox1, dropDownBox2, datePicker.getValue(), timeText.getText());
                listUser.saveCloseContact();
                timeText.clear();
            }
        });

        // Load button events
        load_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String load_user = listUser.loadList();
                dropDownBox1.getItems().addAll(load_user.split("\n"));
                dropDownBox2.getItems().addAll(load_user.split("\n"));
            }
        });
        setContent(grid);
    }
}
