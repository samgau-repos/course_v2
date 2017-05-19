package com.samgau.start.web.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Tolegen Izbassar on 19.05.2017.
 */
public final class JsfUtils {

    private JsfUtils() {
    }

    public static void addSuccessMessage(String message) {
        FacesMessage facesMessage =
                new FacesMessage("Успешно", message);
        FacesContext.getCurrentInstance()
                .addMessage(null, facesMessage);
    }
}
