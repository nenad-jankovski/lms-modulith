package com.jnenad.lms.ratings;

public interface RatingExternalAPI {
    void rateCourse(Long courseId, int starts, Long userId);
    int getRating(Long courseId);
    int getAvgRatingByUser(Long userId);
}
