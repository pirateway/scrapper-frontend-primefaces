package com.pirateway.scrapper.frontend.primefaces.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pirateway.scrapper.frontend.primefaces.model.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    User findByLogin(
            @NotNull final String login);
}