package com.everis.beca.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.everis.beca.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
