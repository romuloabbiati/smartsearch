package com.smartgroup.smartsearch.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartgroup.smartsearch.dto.GameDTO;
import com.smartgroup.smartsearch.entities.Game;
import com.smartgroup.smartsearch.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		List<Game> games = gameRepository.findAll();
		return games.stream().map(game -> new GameDTO(game))
			.collect(Collectors.toList());
	}
	
}
