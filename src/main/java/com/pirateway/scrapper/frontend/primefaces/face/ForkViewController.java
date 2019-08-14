package com.pirateway.scrapper.frontend.primefaces.face;

import com.pirateway.scrapper.frontend.primefaces.api.service.IForkService;
import com.pirateway.scrapper.frontend.primefaces.enumerate.Status;
import com.pirateway.scrapper.frontend.primefaces.exception.AuthenticationSecurityException;
import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
import com.pirateway.scrapper.frontend.primefaces.model.dto.ProjectDTO;
import com.pirateway.scrapper.frontend.primefaces.model.dto.UserDTO;
import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
import com.pirateway.scrapper.frontend.primefaces.scrapper.BetScrapper;
import com.pirateway.scrapper.frontend.primefaces.util.OptionsUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@SessionScope
public class ForkViewController {

    @Nullable
    private List<Fork> forks;

    @Nullable
    private Fork selectedFork;

    @NotNull
    private Fork editFork;

    @NotNull
    @Autowired
    private IForkService forkService;

    @NotNull
    @Autowired
    private BetScrapper betScrapper;

    public Collection<Fork> getForks(
    ) throws DataValidateException {
        forks = new ArrayList<>(forkService.findAll());
        return forks;
    }

    public void setForks(List<Fork> forks) {
        this.forks = forks;
    }

    public void refreshForks(
    ) throws DataValidateException, IOException {
        betScrapper.clear();
        betScrapper.refresh();
    }

    @NotNull
    public Fork getEditFork(
    ){
        return editFork;
    }

    public void setEditFork(
            @NotNull final Fork editFork
    ) {
        this.editFork = editFork;
    }

    @Nullable
    public Fork getSelectedFork() {
        return selectedFork;
    }

    public void setSelectedFork(
            @Nullable Fork selectedFork
    ) {
        this.selectedFork = selectedFork;
    }

    public void onRowSelect(SelectEvent event) {
        selectedFork = ((Fork) event.getObject());
    }

    public void onRowUnselect(UnselectEvent event) {
        selectedFork = null;
    }

}
