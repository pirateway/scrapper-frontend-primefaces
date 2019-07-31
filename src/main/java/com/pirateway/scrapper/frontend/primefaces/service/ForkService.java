package com.pirateway.scrapper.frontend.primefaces.service;

import com.pirateway.scrapper.frontend.primefaces.api.repository.IForkRepository;
import com.pirateway.scrapper.frontend.primefaces.api.service.IForkService;
import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
import com.pirateway.scrapper.frontend.primefaces.util.DataValidator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ForkService implements IForkService {


    @NotNull
    final private IForkRepository forkRepository;

    @Autowired
    public ForkService(
            @NotNull final IForkRepository forkRepository
    ) {
        this.forkRepository = forkRepository;
    }

    @Override
    @Transactional
    public void create(@Nullable Fork fork
    ) throws DataValidateException {
        DataValidator.validateFork(fork);
        forkRepository.save(fork);
    }

    @Override
    @Transactional
    public void clear() throws DataValidateException {
        forkRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Fork> findAll() throws DataValidateException {
        return forkRepository.findAll();
    }
}
