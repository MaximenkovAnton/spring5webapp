package me.spring.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String nick;
    @Getter @Setter
    private String address;

    public String introduce(){
        if(firstName != null || lastName != null) return introduceByRealName();
        return introduceByNick();
    }

    private String introduceByNick() {
        return nick;
    }

    private String introduceByRealName() {
        String name = "";
        if(firstName != null) name = firstName;
        if(lastName != null){
            if(!name.isEmpty()) name = name.concat(" ");
            name = name.concat(lastName);
        }
        return name;
    }
}
