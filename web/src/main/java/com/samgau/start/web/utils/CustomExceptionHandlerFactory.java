package com.samgau.start.web.utils;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Created by Tolegen Izbassar on 20.05.2017.
 */
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {

    private final ExceptionHandlerFactory factory;

    public CustomExceptionHandlerFactory(ExceptionHandlerFactory factory) {
        this.factory = factory;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        return new CustomExceptionHandler(
                factory.getExceptionHandler()
        );
    }
}
