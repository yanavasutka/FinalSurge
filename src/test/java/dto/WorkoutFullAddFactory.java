package dto;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WorkoutFullAddFactory {

    public static WorkoutFullAdd getRunWorkoutWithValidData() {
        Faker faker = new Faker();
        return WorkoutFullAdd.builder()
                .workoutDate("05/30/2022")
                .timeOfDay("09:00 PM")
                .workoutName(faker.name().name())
                .workoutDescription(faker.toString())
                .plannedDistance("5")
                .plannedDistanceType("km")
                .plannedDuration("30:00:00")
                .distance("5")
                .distanceType("km")
                .duration("32:50:32")
                .pace("10:34")
                .paceType("min/mi")
                .overallPlace("2")
                .ageGroupPlace("2")
                .howIFelt("Normal")
                .perceivedEffort("3 (Light)")
                .minHR("80")
                .avgHR("100")
                .maxHR("129")
                .caloriesBurned("250")
                .build();
    }

    public static WorkoutFullAdd getBikeWorkoutWithValidData() {
        Faker faker = new Faker();
        return WorkoutFullAdd.builder()
                .workoutDate("05/30/2022")
                .timeOfDay("09:00 PM")
                .workoutName(faker.name().name())
                .workoutDescription(faker.toString())
                .plannedDistance("5")
                .plannedDistanceType("km")
                .plannedDuration("30:00:00")
                .distance("5")
                .distanceType("km")
                .duration("32:50:32")
                .pace("24:29")
                .paceType("min/100m")
                .elevationGain("5")
                .elevationGainDistType("ft")
                .elevationLoss("2")
                .elevationLossDistType("ft")
                .overallPlace("2")
                .ageGroupPlace("2")
                .howIFelt("Normal")
                .perceivedEffort("3 (Light)")
                .avgPower("20")
                .maxPower("30")
                .avgCadence("50")
                .maxCadence("52")
                .minHR("80")
                .avgHR("100")
                .maxHR("129")
                .caloriesBurned("250")
                .build();
    }

    public static WorkoutFullAdd getBikeWorkoutWithInvalidData() {
        Faker faker = new Faker();
        return WorkoutFullAdd.builder()
                .workoutDate(" ")
                .timeOfDay("$%^")
                .workoutName("@#$%TYJJKJBNMNBVC??????????????????????????????????????>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ1")
                .workoutDescription(faker.toString())
                .plannedDistance(":?dff")
                .plannedDistanceType("km")
                .plannedDuration(";%К22")
                .distance("15ААА")
                .distanceType("km")
                .duration("bnn:50:32")
                .pace("1sd&&*")
                .paceType("min/mi")
                .elevationGain("dfg")
                .elevationGainDistType("ft")
                .elevationLoss("dfg")
                .elevationLossDistType("ft")
                .overallPlace("bnn")
                .ageGroupPlace("fhf")
                .howIFelt("Good")
                .perceivedEffort("Select...")
                .avgPower("&*(")
                .maxPower("30sdfgh")
                .avgCadence("dfgh")
                .maxCadence("xcv45")
                .minHR("$%%")
                .avgHR(")))")
                .maxHR("301")
                .caloriesBurned("+++")
                .build();
    }

}
