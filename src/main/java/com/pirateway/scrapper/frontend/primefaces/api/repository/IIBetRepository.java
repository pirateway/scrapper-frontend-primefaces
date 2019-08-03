package com.pirateway.scrapper.frontend.primefaces.api.repository;

import com.pirateway.scrapper.frontend.primefaces.model.entity.Bet;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IIBetRepository {

    void add(final Bet bet);

    public List<Bet> findAll();

    public void showAllBets();

    public void clear();

}
