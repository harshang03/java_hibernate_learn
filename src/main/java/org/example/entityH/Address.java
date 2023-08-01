package org.example.entityH;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "aid")
    @GenericGenerator(name = "aid", strategy = "increment")
    private int addressID;
    @Column
    private String address;
    @ManyToOne
    @JoinColumn(name = "sID")
    private Student student;

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
