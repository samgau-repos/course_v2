package com.samgau.start.web.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

/**
 * Created by Tolegen Izbassar on 19.05.2017.
 */
public final class JsfUtils {

    private static final String BUNDLE_NAME = "messages";

    private JsfUtils() {
    }

    public static void addSuccessMessage(String message) {
        FacesMessage facesMessage =
                new FacesMessage("Успешно", message);
        getCurrentContext()
                .addMessage(null, facesMessage);
    }

    public static void addErrorMessage(String message) {
        FacesMessage facesMessage =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", message);
        getCurrentContext().addMessage(null, facesMessage);
    }

    public static String getLocalizedMessage(String path) {
        ResourceBundle bundle = getCurrentContext().getApplication()
                .getResourceBundle(getCurrentContext(), BUNDLE_NAME);
        return bundle.getString(path);
    }

    private static FacesContext getCurrentContext() {
        return FacesContext.getCurrentInstance();
    }
}
