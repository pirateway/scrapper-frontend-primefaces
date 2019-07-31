package com.pirateway.scrapper.frontend.primefaces.model.dto;


import org.jetbrains.annotations.Nullable;
import com.pirateway.scrapper.frontend.primefaces.enumerate.Status;

import java.util.Date;

public class ProjectDTO extends BaseEntityDTO {

    public ProjectDTO(
            @Nullable final String name,
            @Nullable final String description,
            @Nullable final Date dateBeing,
            @Nullable final Date dateEnd,
            @Nullable final Status status,
            @Nullable final String userId) {
        this.name = name;
        this.description = description;
        this.dateBegin = dateBeing;
        this.dateEnd = dateEnd;
        this.status = status;
        this.userId = userId;
    }


}
