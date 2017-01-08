package com.qrcode.web.services.generator.validators;

/**
 * Created by grijesh on 8/1/17.
 */

@FunctionalInterface
public interface Validator<T extends Object> {
    void valid(T input);
}
