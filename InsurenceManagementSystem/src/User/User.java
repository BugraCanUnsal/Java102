package User;

import Address.Address;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String profession;
    private int age;
    private ArrayList<Address> addresses = new ArrayList<>();
    private Date lastSignIn;

    public User(String name, String surname, String email, String password, String profession, int age, Date lastSignIn) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.profession = profession;
        this.age = age;
        this.lastSignIn = lastSignIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Address address) {
        this.addresses.add(address);
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
}
