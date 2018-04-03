package me.spring.test.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String nick;
    String address;

    public String introduce() {
        if (hasFirstOrLastName())
            return introduceByRealName();
        return introduceByNick();
    }

    private boolean hasFirstOrLastName() {
        return firstName != null || lastName != null;
    }

    private String introduceByNick() {
        return nick;
    }

    private String introduceByRealName() {
        String name = "";
        if (firstName != null) name = firstName;
        if (lastName != null) {
            if (!name.isEmpty()) name = name.concat(" ");
            name = name.concat(lastName);
        }
        return name;
    }
}