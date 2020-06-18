//package com.pirateway.scrapper.frontend.primefaces.face;
//
//import com.pirateway.scrapper.frontend.primefaces.model.dto.UserDTO;
//import com.pirateway.scrapper.frontend.primefaces.util.DataValidator;
//import com.pirateway.scrapper.frontend.primefaces.util.HashUtil;
//import com.pirateway.scrapper.frontend.primefaces.util.OptionsUtil;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import org.primefaces.PrimeFaces;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import com.pirateway.scrapper.frontend.primefaces.api.service.IUserService;
//import com.pirateway.scrapper.frontend.primefaces.enumerate.Role;
//import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//
//@Controller
//public class RegistrationViewController {
//
//    @NotNull
//    private UserDTO registeredUser;
//
//    @Autowired
//    IUserService userService;
//
//    @NotNull
//    public UserDTO getRegisteredUser() {
//        return registeredUser;
//    }
//
//    public void setRegisteredUser(@NotNull UserDTO registeredUser) {
//        this.registeredUser = registeredUser;
//    }
//
//    public void registrationUser() {
//        @NotNull final FacesContext context = FacesContext.getCurrentInstance();
//        registeredUser = new UserDTO(
//                "New User",
//                "password",
//                "New user name",
//                "Description for new user",
//                Role.USER);
//        PrimeFaces.current().dialog().openDynamic("registrationOutcome", OptionsUtil.getWindowOptions(), null);
//    }
//
//    public void saveUser() {
//        @Nullable final String password = registeredUser.getPassword();
//        if (!DataValidator.stringIsNull(password))
//            registeredUser.setPassword(HashUtil.md5(password));
//        try {
//            userService.create(registeredUser);
//            PrimeFaces.current().dialog().closeDynamic("registrationOutcome");
//        } catch (DataValidateException e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Input Error:", e.getMessage()));
//        }
//    }
//}
