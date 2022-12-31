package com.smartgroup.smartsearch.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartgroup.smartsearch.dto.RecordDTO;
import com.smartgroup.smartsearch.dto.RecordInsertDTO;
import com.smartgroup.smartsearch.entities.Game;
import com.smartgroup.smartsearch.entities.Record;
import com.smartgroup.smartsearch.repositories.GameRepository;
import com.smartgroup.smartsearch.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record record = new Record();
		record.setName(dto.getName());
		record.setAge(dto.getAge());
		record.setMoment(Instant.now());
		Game game = gameRepository.getOne(dto.getGameId());
		record.setGame(game);
		
		record = recordRepository.save(record);
		
		return new RecordDTO(record);
	}
	
}
