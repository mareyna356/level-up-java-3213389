package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
        List<String> studentsWithIncompleteVolunteerEvents = new ArrayList<String>();

        for (String student : students) {
            int numEvents = 0;
            Set<Map.Entry<String, List<String>>> entrySetAttendeesMapping = attendeesMapping.entrySet();
            for (Map.Entry<String, List<String>> entry : entrySetAttendeesMapping) {
                List<String> attendees = entry.getValue();
                if (attendees.contains(student))
                    numEvents++;
                if (numEvents == 2)
                    break;
            }
            if (numEvents < 2)
                studentsWithIncompleteVolunteerEvents.add(student);
        }

        String[] temp = studentsWithIncompleteVolunteerEvents
                .toArray(new String[studentsWithIncompleteVolunteerEvents.size()]);

        return List.of(temp);
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
