package com.samgau.start.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 * Created by Tolegen Izbassar on 20.05.2017.
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private final ExceptionHandler exceptionHandler;
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return exceptionHandler;
    }

    @Override
    public void handle() throws FacesException {
        getUnhandledExceptionQueuedEvents().forEach(
            event -> {
                ExceptionQueuedEventContext context = event.getContext();
                Throwable throwable = context.getException();
                LOGGER.error(throwable.getLocalizedMessage(), throwable);
                throwable = getRootCause(throwable);
                JsfUtils.addErrorMessage(
                        throwable.getLocalizedMessage()
                );
            }
        );
    }
}
