package ru.laskarev.springApps;

public class MyFirstBean {
    private final String date = "07.07.2022";

    private String condition;

    public MyFirstBean(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
