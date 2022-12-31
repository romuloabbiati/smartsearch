package com.smartgroup.smartsearch.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
