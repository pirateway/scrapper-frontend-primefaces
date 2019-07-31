package com.pirateway.scrapper.frontend.primefaces.api.service;

import com.pirateway.scrapper.frontend.primefaces.model.dto.SessionDTO;
import com.pirateway.scrapper.frontend.primefaces.model.dto.UserDTO;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import com.pirateway.scrapper.frontend.primefaces.exception.AuthenticationSecurityException;
import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;

import javax.servlet.http.HttpSession;

@Service
public interface ISessionService {

    void validate(
            @Nullable final HttpSession session
    ) throws AuthenticationSecurityException;

    void validateAdmin(
            @Nullable final HttpSession session
    ) throws AuthenticationSecurityException, DataValidateException;

    boolean isUser(
            @Nullable final HttpSession session);

    boolean isAdmin(
            @Nullable final HttpSession session);

    UserDTO getLoggedUser(
            @Nullable final HttpSession session) throws AuthenticationSecurityException;

    void validateEndpointSession(
            @NotNull final SessionDTO sessionDTO
    ) throws DataValidateException;

    void validateEndpointAdminSession(
            @NotNull final SessionDTO sessionDTO
    ) throws AuthenticationSecurityException, DataValidateException;
}
