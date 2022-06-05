package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutQuickAdd {
    String workoutDate;
    String timeOfDay;
    String activityType;
    String workoutName;
    String workoutDescription;
    String plannedDistance;
    String plannedDistanceType;
    String plannedDuration;
    String distance;
    String distanceType;
    String duration;
    String pace;
    String paceType;
    String howIFelt;
    String perceivedEffort;
    String postWorkoutNotesResults;
    String overallPlace;
    String ageGroupPlace;
}
