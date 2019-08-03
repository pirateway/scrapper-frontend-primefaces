package com.pirateway.scrapper.frontend.primefaces.api.service;

import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
import com.pirateway.scrapper.frontend.primefaces.model.entity.Bet;
import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public interface IBetService {

    @Transactional
    void create(
            @Nullable final Bet bet
    ) throws DataValidateException;

    /*@Transactional
    void edit(
            @Nullable final ProjectDTO projectDTO
    ) throws DataValidateException;

    @Transactional(readOnly = true)
    ProjectDTO findOne(
            @Nullable final String id,
            @Nullable final String userId
    ) throws DataValidateException;

    @Transactional
    void remove(
            @Nullable final String userId
    ) throws DataValidateException;*/

    @Transactional(readOnly = true)
    Collection<Bet> findByFork(
            @Nullable final Fork fork
    ) throws DataValidateException;

    @Transactional
    void removeByFork(
            @Nullable final Fork fork
    ) throws DataValidateException;

    @Transactional
    void clear(
    ) throws DataValidateException;

    /*@Transactional(readOnly = true)
    ProjectDTO findOne(
            @Nullable final String id
    ) throws DataValidateException;

    @Transactional
    void remove(
            @Nullable final String id
    ) throws DataValidateException;
*/
    @Transactional(readOnly = true)
    List<Bet> findAll(
    ) throws DataValidateException;
}
