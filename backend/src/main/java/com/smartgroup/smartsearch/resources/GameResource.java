package com.smartgroup.smartsearch.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartgroup.smartsearch.entities.Game;

@RestController
@RequestMapping(path = "/games")
public class GameResource {
	
	@GetMapping
	public ResponseEntity<List<Game>> findAll() {
		List<Game> list = gameRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
