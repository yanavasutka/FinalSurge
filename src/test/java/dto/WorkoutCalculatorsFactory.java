package dto;

public class WorkoutCalculatorsFactory {

    public static WorkoutCalculators getCalculatorsData() {
        return WorkoutCalculators.builder()
                .selectEvent("Mile")
                .hoursIntensity("1")
                .minutesIntensity("50")
                .secondsIntensity("20")


                .distanceHansons("Marathon")
                .distance("10")
                .distanceType("km")
                .hoursHansons("1")
                .minutesHansons("10")
                .secondsHansons("33")
                .temperature("36")
                .temperatureType("°C")
                .humidity("65")
                .windSpeed("3")
                .speedType("kph")


                .distanceMillan("1000m")
                .hoursMillan("1")
                .minutesMillan("40")
                .secondsMillan("41")


                .raceDistance("5 km")
                .hoursTinman("1")
                .minutesTinman("10")
                .secondsTinman("2")
                .gender(" Female")


                .CP("200")
                .RWC("100")

                .shortTestMinutes("10")
                .shortTestSeconds("20")
                .shortTestAvgPower("12")
                .longTestMinutes("23")
                .longTestSeconds("58")
                .longTestAvgPower("100")

                .raceHours("2")
                .raceMinutes1("20")
                .raceSeconds1("56")
                .raceAvgPower1("29")

                .raceMinutes2("23")
                .raceSeconds2("23")
                .raceAvgPower2("20")
                .build();
    }
}
