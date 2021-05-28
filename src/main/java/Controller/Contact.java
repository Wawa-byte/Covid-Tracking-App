package Controller;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Contact {

    private int id1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id2;
    private LocalDate contactDate;
    private String time;

    public Contact(int id1, int id2, LocalDate contactDate, String time){
        this.id1 = id1;
        this.id2 = id2;
        this.contactDate = contactDate;
        this.time = time;
    }

    public Contact(){
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public LocalDate getContactDate() {
        return contactDate;
    }
    public void setContactDate(LocalDate contactDate) {
        this.contactDate = contactDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
