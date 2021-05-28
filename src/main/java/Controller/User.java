package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String fName;
    private String lName;
    private String id;
    private String number;
    private String dateEnter;
    private String timeEnter;

    ArrayList<User> closeContact = new ArrayList();

    public User (String fname, String lname, String id_num, String num){
        fName = fname;
        lName = lname;
        id = id_num;
        number = num;
    }

    public ArrayList<User> getCloseContact() {
        return closeContact;
    }

    public void setCloseContact(User closeContacts) {

        closeContact.add(closeContacts);
    }

    public String getDateEnter() {
        return dateEnter;
    }

    public void setDateEnter(String dateEnter) {
        this.dateEnter = dateEnter;
    }

    public String getTimeEnter() {
        return timeEnter;
    }

    public void setTimeEnter(String timeEnter) {
        this.timeEnter = timeEnter;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Name: " + fName + " " + lName + " Unique ID: " + id + " Phone Number: " + number + "\n";
    }

}
