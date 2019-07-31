package com.pirateway.scrapper.frontend.primefaces.api.repository;

import com.pirateway.scrapper.frontend.primefaces.model.entity.Bet;
import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IBetRepository extends JpaRepository<Bet, String> {

    Collection<Bet> findAllByFork(
            @NotNull final Fork fork);


}
