package com.smartgroup.smartsearch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartgroup.smartsearch.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
