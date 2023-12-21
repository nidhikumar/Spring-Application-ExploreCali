package com.example.ec.explorecali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.explorecali.domain.Difficulty;
import com.example.ec.explorecali.domain.Region;
import com.example.ec.explorecali.domain.Tour;
import com.example.ec.explorecali.domain.TourPackage;
import com.example.ec.explorecali.repo.TourPackageRepository;
import com.example.ec.explorecali.repo.TourRepository;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository){
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region){

        TourPackage tourPackage = tourPackageRepository.findById(tourPackageName).orElseThrow(()->
             new RuntimeException("Tour package does not exist: " + tourPackageName));

        return tourRepository.save(new Tour(price, title, description, blurb, price, duration,
                bullets, keywords, tourPackage, difficulty, region));
    }
    
    public long total() {
        return tourRepository.count();
    }
}
