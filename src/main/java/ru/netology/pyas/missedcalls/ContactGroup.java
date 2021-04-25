package ru.netology.pyas.missedcalls;

public enum ContactGroup {
    WORK("Работа"), FRIENDS("Друзья"), FAMILY("Семья");

    private String title;

    private ContactGroup(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
