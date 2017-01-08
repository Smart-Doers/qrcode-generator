package com.qrcode.generator.exception;

/**
 * Created by grijesh on 7/1/17.
 *
 */
public class QrCodeException extends RuntimeException {

    public QrCodeException(String message) {
        super(message);
    }

    public QrCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
