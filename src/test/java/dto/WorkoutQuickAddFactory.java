package dto;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WorkoutQuickAddFactory {

    public static WorkoutQuickAdd getWorkoutWithValidData() {
        Faker faker = new Faker();
        return WorkoutQuickAdd.builder()
                .workoutDate("5/3/2022")
                .timeOfDay("12:00 AM")
                .activityType("    -Run: Long Run")
                .workoutName(faker.name().name())
                .workoutDescription(faker.toString())
                .plannedDistance("5")
                .plannedDistanceType("km")
                .plannedDuration("30:00:00")
                .distance("5")
                .distanceType("km")
                .duration("32:50:50")
                .pace("10:34")
                .paceType("min/mi")
                .howIFelt("Normal")
                .perceivedEffort("4 (Moderate)")
                .postWorkoutNotesResults(faker.toString())
                .overallPlace("2")
                .ageGroupPlace("2")
                .build();
    }

    public static WorkoutQuickAdd getWorkoutWithInvalidData() {
        Faker faker = new Faker();
        return WorkoutQuickAdd.builder()
                .workoutDate(" ")
                .timeOfDay("DFGTER^&")
                .activityType("Select...")
                .workoutName("@#$%TYJJKJBNMNBVC??????????????????????????????????????>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ1")
                .workoutDescription(faker.toString())
                .plannedDistance("/bla/")
                .plannedDistanceType("km")
                .plannedDuration("$&**(")
                .distance("bla")
                .distanceType("km")
                .duration("$%GBNMJ")
                .pace("&&&")
                .paceType("min/mi")
                .howIFelt("Normal")
                .perceivedEffort("4 (Moderate)")
                .postWorkoutNotesResults(faker.toString())
                .overallPlace("bla%&**")
                .ageGroupPlace("blaGHJK")
                .build();
    }
}
