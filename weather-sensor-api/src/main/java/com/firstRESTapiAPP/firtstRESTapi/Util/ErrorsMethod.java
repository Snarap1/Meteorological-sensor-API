package com.firstRESTapiAPP.firtstRESTapi.Util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorsMethod {
    public  static  void returnErrors(BindingResult bindingResult){
        StringBuilder errMsg = new StringBuilder();

        List<FieldError> errors  = bindingResult.getFieldErrors();
        for(FieldError error : errors) {
            errMsg.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage() == null? error.getCode() : error.getDefaultMessage())
                    .append(";");

        }
        throw  new SensorException(errMsg.toString());
    }
}
