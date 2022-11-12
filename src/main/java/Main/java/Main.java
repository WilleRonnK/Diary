package Main.java;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.text;


public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * Ett program som tillåter användaren att skriva in inlägg och sedan sparas dessa inlägg.
         */
        ObjectMapper mapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);
        List<UserEntry> userEntries = List.of(mapper.readValue(Paths.get("src/main/resources/user.json").toFile(), UserEntry[].class));

        int choices = 0;

        while (choices != 3) {
            mainMenuMessage();
            choices = Integer.parseInt(scanner.nextLine());

        switch (choices) {
            case 2:
                List<UserEntry> userEntry1 = new ArrayList<>(userEntries);
                System.out.println("Skriv in en titel");
                String title = scanner.nextLine();
                System.out.println("Skriv in ditt inlägg");
                String text = scanner.nextLine();
                String date = LocalDate.now().toString();
                UserEntry newUserEntry = new UserEntry(date,text,title);
                userEntry1.add(newUserEntry);
                mapper.writeValue(Paths.get("src/main/resources/user.json").toFile(), userEntry1);
                System.out.println(newUserEntry.getDate());
                System.out.println("Title: "+newUserEntry.getTitle());
                System.out.println("Text: " +newUserEntry.getText());
                mainMenuMessage();
                choices = Integer.parseInt(scanner.nextLine());

                /**
                 * Skriver ut anvädarens inlägg till användaren.
                 */
            case 1:
                List<UserEntry> userEntriesUpdated = List.of(mapper.readValue(Paths.get("src/main/resources/user.json").toFile(), UserEntry[].class));
                for (UserEntry userEnter22 : userEntriesUpdated) {
                    System.out.println(userEnter22.getDate());
                    System.out.println("Title: "+userEnter22.getTitle());
                    System.out.println("Text:" + userEnter22.getText());
                    System.out.println("-------------------");
                }
                mainMenuMessage();
                choices = Integer.parseInt(scanner.nextLine());
                /**
                 * Avslutar programmet
                 */
        }
            choices = 3;

            }

        }







static void mainMenuMessage(){
    System.out.println("Välkommen till din dagbok, vad vill du göra?");
    System.out.println("1. Se dina inlägg");
    System.out.println("2. Skriva ett inlägg");
    System.out.println("3. Avsluta programmet");
}
}
