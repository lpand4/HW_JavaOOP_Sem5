package org.example.Model;

import java.util.Date;

public abstract class User {
    Date dateBirth;
    String fio;
    int id;
    Date weekend;

    public User(Date dateBirth, String fio, int id) {
        this.dateBirth = dateBirth;
        this.fio = fio;
        this.id = id;
    }

    public User() {
    }
}
