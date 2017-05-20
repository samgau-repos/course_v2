package com.samgau.start.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Tolegen Izbassar on 20.05.2017.
 */
@RequestScoped
@ManagedBean
public class LoginBean {

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index";
    }
}
