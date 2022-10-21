package Main.java;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.text;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choices = 0;
        String userInput;
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntry> userEntries = List.of(mapper.readValue(Paths.get("src/main/resources/user.json").toFile(), UserEntry[].class));

        while (choices != 3) {
            mainMenuMessage();
            choices = Integer.parseInt(scanner.nextLine());

        switch (choices) {
            case 2:
                List<UserEntry> userEntry1 = new ArrayList<>(userEntries);
                UserEntry userEntry = new UserEntry();
                System.out.println("Skriv in en titel");
                String title = scanner.nextLine();
                userEntry.setTitle(title);
                System.out.println("Skriv in ditt inlägg");
                String text = scanner.nextLine();
                userEntry.setText(text);
                String date = LocalDate.now().toString();
                userEntry.setDate(date);

                UserEntry newUserEntry = new UserEntry(date,text,title);
                userEntry1.add(newUserEntry);
                mapper.writeValue(Paths.get("src/main/resources/user.json").toFile(), userEntry1);

                mainMenuMessage();
               choices = Integer.parseInt(scanner.nextLine());
                break;
            case 1:
                List<UserEntry> userEntriesUpdated = List.of(mapper.readValue(Paths.get("src/main/resources/user.json").toFile(), UserEntry[].class));
                for (UserEntry userEnter : userEntriesUpdated)
                    System.out.println(userEnter.getText());



        }
        }

    }





static void mainMenuMessage(){
    System.out.println("Välkommen till din dagbok, vad vill du göra?");
    System.out.println("1. Se dina inlägg");
    System.out.println("2. Skriva ett inlägg");
    System.out.println("3. Avsluta programmet");
}
}
