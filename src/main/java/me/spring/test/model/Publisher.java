package me.spring.test.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;
    private String address;

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
