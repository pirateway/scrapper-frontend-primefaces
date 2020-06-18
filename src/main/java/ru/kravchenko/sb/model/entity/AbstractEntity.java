package ru.kravchenko.sb.model.entity;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @NotNull
    protected String id = UUID.randomUUID().toString();

}
