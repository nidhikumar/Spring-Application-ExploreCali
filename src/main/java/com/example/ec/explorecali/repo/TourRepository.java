package com.example.ec.explorecali.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.ec.explorecali.domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    
}
