package com.smartgroup.smartsearch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartgroup.smartsearch.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
