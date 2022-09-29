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
        mainMenuMessage();
        Scanner scanner = new Scanner(System.in);
        int choices = Integer.parseInt(scanner.nextLine());
        String userInput;
        ObjectMapper mapper = new ObjectMapper();
       List<UserEntry> userEntries = List.of(mapper.readValue(Paths.get("src/main/resources/user.json").toFile(), UserEntry[].class));

    if (choices == 2){
        UserEntry userEntry = new UserEntry();
        System.out.println("Skriv in en titel");
        String titel = scanner.nextLine();
        userEntry.setTitle(titel);
        System.out.println("Skriv in ditt inlägg");
        String text = scanner.nextLine();
        userEntry.setText(text);
        userEntry.setDate(LocalDate.now().toString());
        System.out.println(userEntry.getDate());

        mainMenuMessage();
        List<UserEntry> userEntry1 = new ArrayList<>();
        userEntry1.addAll(userEntries);
        userEntry1.add(userEntry);
        mapper.writeValue(Paths.get("src/main/resources/user.json").toFile(), userEntry1);
    }
        if (choices == 1){
    return;

        }
    if (choices == 3){
        System.out.println("Tack och hej");
    }



    }
static void mainMenuMessage(){
    System.out.println("Välkommen till din dagbok, vad vill du göra?");
    System.out.println("1. Se dina inlägg");
    System.out.println("2. Skriva ett inlägg");
    System.out.println("3. Avsluta programmet");
}
}
