package ru.kravchenko.sb.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "app_user")
public class User extends AbstractEntity {

    @Nullable
    @Column(unique = true)
    private String login = "";

    @Nullable
    private String password = "";

    public User(@Nullable String login, @Nullable String password) {
        this.login = login;
        this.password = password;
    }

}
