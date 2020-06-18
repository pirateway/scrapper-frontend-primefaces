//package com.pirateway.scrapper.frontend.primefaces.face;
//
//import com.pirateway.scrapper.frontend.primefaces.api.service.ISessionService;
//import com.pirateway.scrapper.frontend.primefaces.model.dto.ProjectDTO;
//import com.pirateway.scrapper.frontend.primefaces.model.dto.UserDTO;
//import com.pirateway.scrapper.frontend.primefaces.util.BootStrap;
//import com.pirateway.scrapper.frontend.primefaces.util.OptionsUtil;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import org.primefaces.PrimeFaces;
//import org.primefaces.event.SelectEvent;
//import org.primefaces.event.UnselectEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.context.annotation.SessionScope;
//import com.pirateway.scrapper.frontend.primefaces.api.service.IProjectService;
//import com.pirateway.scrapper.frontend.primefaces.enumerate.Status;
//import com.pirateway.scrapper.frontend.primefaces.exception.AuthenticationSecurityException;
//import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@SessionScope
//public class ProjectViewController {
//
//    @Nullable
//    private List<ProjectDTO> projects;
//
//    @Nullable
//    private ProjectDTO selectedProject;
//
//    @NotNull
//    private ProjectDTO editProject;
//
//    @NotNull
//    @Autowired
//    private IProjectService projectService;
//
//    @NotNull
//    @Autowired
//    private ISessionService sessionService;
//
//    @NotNull
//    @Autowired
//    private BootStrap bootStrap;
//
//    public Collection<ProjectDTO> getProjects(
//    ) throws AuthenticationSecurityException, DataValidateException {
//        @NotNull final FacesContext context = FacesContext.getCurrentInstance();
//        @NotNull final HttpSession session = (HttpSession) context
//                .getExternalContext()
//                .getSession(false);
//        sessionService.validate(session);
//        @NotNull final UserDTO loggedUser = sessionService.getLoggedUser(session);
//        projects = new ArrayList<>(projectService.findAllByUserId(loggedUser.getId()));
//        bootStrap.init();
//        return projects;
//    }
//
//    public void setProjects(List<ProjectDTO> projects) {
//        this.projects = projects;
//    }
//
//    public void projectCreate() {
//        @NotNull final FacesContext context = FacesContext.getCurrentInstance();
//        @NotNull final HttpSession session = (HttpSession) context
//                .getExternalContext()
//                .getSession(false);
//        try {
//            sessionService.validate(session);
//            @NotNull final UserDTO loggedUser = sessionService.getLoggedUser(session);
//            editProject = new ProjectDTO(
//                    "New project",
//                    "Description for new project",
//                    new Date(),
//                    null,
//                    Status.PLANNED,
//                    loggedUser.getId());
//            PrimeFaces.current().dialog().openDynamic("projectEditOutcome", OptionsUtil.getWindowOptions(), null);
//        } catch (AuthenticationSecurityException e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Authentication Error:", e.getMessage()));
//        }
//
//    }
//
//    @NotNull
//    public ProjectDTO getEditProject(
//    ) throws AuthenticationSecurityException {
//        @NotNull final FacesContext context = FacesContext.getCurrentInstance();
//        @NotNull final HttpSession session = (HttpSession) context
//                .getExternalContext()
//                .getSession(false);
//        sessionService.validate(session);
//        return editProject;
//    }
//
//    public void setEditProject(
//            @NotNull final ProjectDTO editProject
//    ) {
//        this.editProject = editProject;
//    }
//
//    @Nullable
//    public ProjectDTO getSelectedProject() {
//        return selectedProject;
//    }
//
//    public void setSelectedProject(
//            @Nullable ProjectDTO selectedProject
//    ) {
//        this.selectedProject = selectedProject;
//    }
//
//    public void onRowSelect(SelectEvent event) {
//        selectedProject = ((ProjectDTO) event.getObject());
//    }
//
//    public void onRowUnselect(UnselectEvent event) {
//        selectedProject = null;
//    }
//
//    public void projectDelete() {
//        try {
//            @NotNull final FacesContext context = FacesContext.getCurrentInstance();
//            @NotNull final HttpSession session = (HttpSession) context
//                    .getExternalContext()
//                    .getSession(false);
//            sessionService.validate(session);
//            @NotNull final UserDTO loggedUser = sessionService.getLoggedUser(session);
//            if (selectedProject == null) {
//                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Input Error:", "No project selected!"));
//                return;
//            }
//            projectService.remove(selectedProject.getId(), loggedUser.getId());
//        } catch (DataValidateException e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Input Error:", e.getMessage()));
//        } catch (AuthenticationSecurityException e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Authentication Error:", e.getMessage()));
//        }
//    }
//
//    public void projectEdit() {
//        if (selectedProject == null) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Input Error:", "No project selected!"));
//            return;
//        }
//        editProject = selectedProject;
//        PrimeFaces.current().dialog().openDynamic("projectEditOutcome", OptionsUtil.getWindowOptions(), null);
//    }
//
//    public Status[] getStatuses() {
//        return Status.values();
//    }
//
//    public void projectSave() {
//        try {
//            if (selectedProject == editProject) {//equality to reference
//                projectService.edit(editProject);
//            } else {
//                projectService.create(editProject);
//            }
//            PrimeFaces.current().dialog().closeDynamic("projectEditOutcome");
//        } catch (DataValidateException e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Input Error:", e.getMessage()));
//        }
//    }
//
//}
