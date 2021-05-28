package Controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userControlTest {

    private userControl userControl;

    public userControlTest(Controller.userControl userControl) {
        this.userControl = userControl;
    }

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void findAll() {
        boolean empty = userControl.findAll().isEmpty();
        assertTrue(empty);
    }

    @Test
    void findContact() {
        boolean empty = userControl.findAll().isEmpty();
        assertTrue(empty);
    }

    @Test
    void searchUserName() {
        boolean empty = userControl.findAll().isEmpty();
        assertTrue(empty);
    }

    @Test
    void searchUserId() {
        boolean empty = userControl.findAll().isEmpty();
        assertTrue(empty);
    }
}