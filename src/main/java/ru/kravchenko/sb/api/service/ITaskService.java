//package com.pirateway.scrapper.frontend.primefaces.api.service;
//
//import com.pirateway.scrapper.frontend.primefaces.model.dto.TaskDTO;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
//
//import java.util.Collection;
//
//@Service
//public interface ITaskService {
//
//    @Transactional
//    void create(
//            @Nullable final TaskDTO taskDTO
//    ) throws DataValidateException;
//
//    @Transactional
//    void edit(
//            @Nullable final TaskDTO taskDTO
//    ) throws DataValidateException;
//
//    @Transactional(readOnly = true)
//    TaskDTO findOne(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException;
//
//    @Transactional
//    void remove(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException;
//
//    @Transactional
//    void clear(
//    ) throws DataValidateException;
//
//    @Transactional(readOnly = true)
//    TaskDTO findOne(
//            @Nullable final String id
//    ) throws DataValidateException;
//
//    @Transactional
//    void remove(
//            @Nullable final String id
//    ) throws DataValidateException;
//
//    @Transactional(readOnly = true)
//    Collection<TaskDTO> findAll(
//    ) throws DataValidateException;
//
//    @Transactional(readOnly = true)
//    Collection<TaskDTO> findAllByProjectId(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException;
//
//    @Transactional(readOnly = true)
//    Collection<TaskDTO> findAllByUserId(
//            @Nullable final String id
//    ) throws DataValidateException;
//
//    @Transactional
//    void removeAllByProjectId(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException;
//
//    @Transactional
//    void removeAllByUserId(
//            @Nullable final String id
//    ) throws DataValidateException;
//
//    @Transactional(readOnly = true)
//    Collection<TaskDTO> sortAllByUserId(
//            @NotNull final String id,
//            @NotNull final String comparator
//    ) throws DataValidateException;
//
//    @Transactional(readOnly = true)
//    Collection<TaskDTO> findAllByPartOfNameOrDescription(
//            @Nullable final String name,
//            @Nullable final String description,
//            @Nullable final String userId
//    ) throws DataValidateException;
//}