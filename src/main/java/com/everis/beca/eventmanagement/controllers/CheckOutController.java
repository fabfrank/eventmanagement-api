package com.everis.beca.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.beca.eventmanagement.controllers.exceptioins.NotCheckedInException;
import com.everis.beca.eventmanagement.entities.Participant;
import com.everis.beca.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckOutController {

	@Autowired
	private ParticipantRepository participantRepository;

	@PostMapping("/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkout(@PathVariable Long id,PersistentEntityResourceAssembler assembler) {

		Participant participant = participantRepository.findOne(id);

		if (participant != null) {
			if (!participant.getCheckedIn()) {
				throw new NotCheckedInException();
			}
			participant.setCheckedIn(false);
			participantRepository.save(participant);
		}

		return ResponseEntity.ok(assembler.toResource(participant));

	}
}
