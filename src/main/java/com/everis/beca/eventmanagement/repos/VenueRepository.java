package com.everis.beca.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.everis.beca.eventmanagement.entities.Venue;

import java.lang.String;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

	Page<Venue> findByPostalCode(@Param("postalCode") String postalcode, Pageable pageable);

}
