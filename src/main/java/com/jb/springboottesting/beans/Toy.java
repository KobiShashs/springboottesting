package com.jb.springboottesting.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * Created by kobis on 26 Jan, 2023
 */
@Entity
@Table(name = "toys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 10)
    private String name;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Cat cat;
}
