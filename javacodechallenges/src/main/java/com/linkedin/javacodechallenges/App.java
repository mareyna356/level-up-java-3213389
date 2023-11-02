package com.linkedin.javacodechallenges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class App {
    public static HashMap<String, Integer> getTicketHolders(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        HashMap<String, Integer> ticketHolders = new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine(); // header
        if (line != null) { // if file is not empty
            line = reader.readLine();
            while (line != null) {
                String[] ticketHolder = StringUtils.split(line, ',');
                ticketHolders.put(ticketHolder[0], Integer.parseInt(ticketHolder[1]));
                line = reader.readLine();
            }
        }
        reader.close();
        return ticketHolders;
    }

    public static void main(String[] args) {
        try {
            HashMap<String, Integer> ticketHolders = getTicketHolders("ticketholders.csv");
            if (ticketHolders.isEmpty()) {
                System.out.println("The CSV file contains no entries.");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ticket holder name:");
            String ticketHolderName = scanner.nextLine();

            if (ticketHolders.containsKey(ticketHolderName)) {
                int numTickets = ticketHolders.get(ticketHolderName).intValue();

                if (numTickets > 0) {
                    System.out.println("Number of attendees:");
                    String numAttendeesString = scanner.nextLine();

                    int numAttendeesInt = Integer.parseInt(numAttendeesString);
                    if (numAttendeesInt > 0) {
                        boolean access = numTickets >= numAttendeesInt;
                        System.out.println(ticketHolderName + " has " + numTickets + " ticket"
                                + (numTickets == 1 ? "" : 's') + ", " + (access ? "" : "not ") + "enough for "
                                + numAttendeesInt + " attendee"
                                + (numAttendeesInt == 1 ? "" : 's')
                                + ": access " + (access ? "granted." : "denied."));
                    } else
                        System.out.println("No attendees present. Operation cancelled.");
                } else
                    System.out.println("This ticket holder hasn't purchased any tickets: access denied.");
            } else
                System.out.println("That ticket holder doesn't exist.");

            scanner.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
