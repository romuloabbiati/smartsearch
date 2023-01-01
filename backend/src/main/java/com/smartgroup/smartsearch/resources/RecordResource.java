package com.smartgroup.smartsearch.resources;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartgroup.smartsearch.dto.RecordDTO;
import com.smartgroup.smartsearch.dto.RecordInsertDTO;
import com.smartgroup.smartsearch.services.RecordService;

@RestController
@RequestMapping(path = "/records")
public class RecordResource {

	@Autowired
	private RecordService recordService;
	
	@PostMapping
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO record) {
		RecordDTO newRecord = recordService.insert(record);
		return ResponseEntity.ok().body(newRecord);
	}
	
	@GetMapping
	public ResponseEntity<Page<RecordDTO>> findByMoments(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		
		Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
		Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<RecordDTO> pageDTO = recordService.findByMoments(minDate, maxDate, pageRequest);
		
		return ResponseEntity.ok(pageDTO);
	}
	
}
