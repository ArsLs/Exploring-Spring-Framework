package ru.laskarev.springApps.ClientOfLibrary;


public class Student extends AbstractClient implements Client {

    public Student(String name, String email) {
        super(name, email);
    }
}
