package com.smartgroup.smartsearch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartgroup.smartsearch.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

}
