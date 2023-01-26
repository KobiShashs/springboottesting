package com.jb.springboottesting.repos;

import com.jb.springboottesting.beans.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kobis on 26 Jan, 2023
 */
@Repository
public interface CatRepository extends JpaRepository<Cat,Long> {
}
