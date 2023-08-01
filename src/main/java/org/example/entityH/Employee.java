package org.example.entityH;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(generator = "eid")
    @GenericGenerator(name = "eid", strategy = "increment")
    private int id;
    private String eName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "joinOFEmpAndDep", joinColumns = {@JoinColumn(name = "eid")}, inverseJoinColumns = {@JoinColumn(name = "did")})
    private List<Department> departments;
}
