package ru.laskarev.springApps.ClientOfLibrary;


public class Teacher extends AbstractClient implements Client {

    public Teacher(String name, String email) {
        super(name, email);
    }
}
