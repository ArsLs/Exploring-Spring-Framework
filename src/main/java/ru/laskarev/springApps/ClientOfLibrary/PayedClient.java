package ru.laskarev.springApps.ClientOfLibrary;

public class PayedClient extends AbstractClient{
    private int balance;

    public PayedClient(String name, String email, int balance) {
        super(name, email);
        this.balance = balance;
    }
}
