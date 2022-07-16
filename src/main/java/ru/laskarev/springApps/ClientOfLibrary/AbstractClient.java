package ru.laskarev.springApps.ClientOfLibrary;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClient implements Client {
    private List<String> takenBooks = new ArrayList<>();
    private String name;
    private String email;

    public AbstractClient(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean takeBook(String book) {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
