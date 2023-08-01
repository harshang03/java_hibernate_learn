package org.example.entityH;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(generator = "did")
    @GenericGenerator(name = "did", strategy = "increment")
    private int id;
    private String dName;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "departments")
    private List<Employee> employees;
}
