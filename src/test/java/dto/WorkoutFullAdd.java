package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutFullAdd {
    String workoutDate;
    String timeOfDay;
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
    String overallPlace;
    String ageGroupPlace;
    String elevationGain;
    String elevationGainDistType;
    String elevationLoss;
    String elevationLossDistType;
    String avgPower;
    String maxPower;
    String avgCadence;
    String maxCadence;
    String howIFelt;
    String perceivedEffort;
    String minHR;
    String avgHR;
    String maxHR;
    String caloriesBurned;
}
