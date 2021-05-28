package Controller;

import java.io.*;

public class userList implements Serializable {

    private final userControl controllingUser;

    /**
     * @author Waleed Akhtar
     * Save the result from the Database into a text file using serialization
     * Calls the methods in the User Control class which fetches data from the MySQL database
     * We store that data in a text file after converting it
     * Then we close the text file so we can save some memory when running the program
     */

    // User List constructor
    public userList(){
        controllingUser = new userControl();
    }

    public void saveList(){ // Save the users added in a serializable list
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("UserLists.txt")); // We convert the objects into bytes and then create a new text file to save them
            {
                os.writeObject(controllingUser.findAll()); // We write to the file by calling the select all method from the controlling class
            }
            os.close(); // We then close the file
        }
        catch (Exception ex){ // For exceptions
            System.out.println("There was a problem with the file");
            ex.printStackTrace(); // Print out the error we had when creating the file
        }
    }

    public void saveCloseContact() {
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("UserClose.txt"));
            {
                os.writeObject(controllingUser.findContact());
            }
            os.close();
        }
        catch (Exception ex){
            System.out.println("There was a problem with the file");
            ex.printStackTrace();
        }
    }

    /**
     * We create a new people object so we can store the data we get from the file in it
     * Using ObjectInputStream we read the objects from the text file
     * Close the text file to save memory
     * We convert the object into a string so it can be printed out in a TextArea
     * @return A string which contains all the info that was in the text file
     */

    public String loadList(){
        Object people = new Object();
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserLists.txt"));
            people = in.readObject();
            in.close();
        }
        catch (Exception ex){
            System.out.println("Could not load UserLists file");
            ex.printStackTrace();
        }
        return String.valueOf(people);
    }
}
