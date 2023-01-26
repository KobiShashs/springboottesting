package com.jb.springboottesting.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.springboottesting.beans.Cat;
import com.jb.springboottesting.beans.Toy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by kobis on 26 Jan, 2023
 */

public abstract class BaseTesting {




    protected Toy t1 = Toy.builder()
            .id(1)
            .name("Tennis")
            .build();

    protected Toy t2 = Toy.builder()
            .id(2)
            .name("Tetris")
            .build();

    protected Toy t3 = Toy.builder()
            .id(3)
            .name("Nintendo")
            .build();

    protected Toy t4 = Toy.builder()
            .id(4)
            .name("Playstation")
            .build();

    protected Cat c1 = Cat.builder()
            .id(1)
            .birthday(Date.valueOf(LocalDate.now().minusYears(5)))
            .name("Mitzi")
            .isCute(true)
            .weight(5.5)
            .toy(t1)
            .toy(t2)
            .build();

    protected Cat c2 = Cat.builder()
            .id(2)
            .birthday(Date.valueOf(LocalDate.now().minusYears(5)))
            .name("Pitzi")
            .isCute(false)
            .weight(15.5)
            .toy(t3)
            .toy(t4)
            .build();

    protected List<Cat> catList = List.of(c1, c2);
}
