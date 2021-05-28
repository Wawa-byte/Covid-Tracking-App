package Controller;

import javax.persistence.*;

@Entity
@Table
public class Person {
    
    private Name name;
    private String phone;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Person(Name name, String phone, String email, int id){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Person() {
        super();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
