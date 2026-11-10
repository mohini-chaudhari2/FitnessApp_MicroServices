package com.fitness.aiservice.service;

import com.fitness.aiservice.Repository.RecommendationRepo;
import com.fitness.aiservice.model.Recommendation;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepo recommendationRepo;

    public List<Recommendation> getUserRecommendation(String userId){
        return recommendationRepo.findByuserId(userId);
    }

    public  Recommendation getActivityRecommendation(String activityId) {

        return recommendationRepo.findByActivityId(activityId)
                .orElseThrow(()-> new RuntimeException("No recommendation found for this activity :" + activityId));
    }
}
