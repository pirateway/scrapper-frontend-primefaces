//package com.pirateway.scrapper.frontend.primefaces.service;
//
//import com.pirateway.scrapper.frontend.primefaces.api.repository.IBetRepository;
//import com.pirateway.scrapper.frontend.primefaces.api.service.IBetService;
//import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
//import com.pirateway.scrapper.frontend.primefaces.model.entity.Bet;
//import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
//import com.pirateway.scrapper.frontend.primefaces.util.DataValidator;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class BetService implements IBetService {
//
//    @NotNull
//    final private IBetRepository betRepository;
//
//    @Autowired
//    public BetService(IBetRepository betRepository) {
//        this.betRepository = betRepository;
//    }
//
//    @Override
//    @Transactional
//    public void create(
//            @Nullable final Bet bet
//    ) throws DataValidateException {
//        DataValidator.validateBet(bet);
//        betRepository.save(bet);
//    }
//
//
//    @Override
//    @Transactional(readOnly = true)
//    public Collection<Bet> findByFork(
//            @Nullable final Fork fork
//    ) throws DataValidateException {
//        DataValidator.validateFork(fork);
//        return betRepository.findAllByFork(fork);
//    }
//
//    @Override
//    @Transactional
//    public void removeByFork(@Nullable Fork fork) throws DataValidateException {
//        DataValidator.validateFork(fork);
//        betRepository.findAllByFork(fork).forEach(betRepository::delete);
//    }
//
//    @Override
//    @Transactional
//    public void clear() throws DataValidateException {
//        betRepository.deleteAll();
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<Bet> findAll() throws DataValidateException {
//        return betRepository.findAll();
//    }
//}
