package ru.laskarev.springApps;

import ru.laskarev.springApps.ClientOfLibrary.Client;
import ru.laskarev.springApps.ClientOfLibrary.PayedClient;
import ru.laskarev.springApps.ClientOfLibrary.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Library {
    private final String name;
    private final Map<Client, List<String>> takenBooks = new HashMap<>();

    public Library(String name) {

        try (Scanner scanner = new Scanner(new File("C:\\Users\\larso\\IdeaProjects\\SpringRealWorldExample\\FirstSpringApp\\src\\main\\resources\\takenBooksTable.txt"))){
            while (scanner.hasNextLine()){
                parseStringFromTakenBooksMap(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        this.name = name;
    }

    private void parseStringFromTakenBooksMap(String s) {
        String[] tableEntry = s.split(":");
        String name = tableEntry[1];
        String email = tableEntry[2];
        List<String> books = Arrays.asList(tableEntry[3].split(";"));
        switch (tableEntry[0]){
            case "Student" :
                takenBooks.put(new Student(name,email), books);
                break;
            case "Teacher" :
                takenBooks.put(new Student(name,email), books);
                break;
            case "PayedClient" :
            {
                String payedClientName = name.split("@")[0];
                int balance = Integer.parseInt(name.split("@")[1]);
                takenBooks.put(new PayedClient(payedClientName, email, balance), books);
                break;
            }
        }

    }

    public Map<Client, List<String>> getTakenBooks() {
        return takenBooks;
    }

    public String getName() {
        return name;
    }


}
