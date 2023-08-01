package org.example.entityH;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "student")
@NamedQuery(name = "display2", query = "from Student where sId=?1")
public class Student {
    @Id
    @GeneratedValue(generator = "sid")
    @GenericGenerator(name = "sid", strategy = "increment")
    private int sId;
    @Column
    private String sName;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Laptop laptop;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

}














