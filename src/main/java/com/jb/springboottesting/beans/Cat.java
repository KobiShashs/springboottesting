package com.jb.springboottesting.beans;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by kobis on 26 Jan, 2023
 */
@Entity
@Table(name = "cats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date birthday;
    private double weight;
    private boolean isCute;
    @Singular
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cat")
    private List<Toy> toys;
}
