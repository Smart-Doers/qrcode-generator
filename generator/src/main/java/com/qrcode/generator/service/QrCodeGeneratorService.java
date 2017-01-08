package com.qrcode.generator.service;

import com.qrcode.generator.exception.QrCodeException;
import com.qrcode.generator.model.QrCode;

import java.io.InputStream;

/**
 * Created by grijesh on 7/1/17.
 */
public interface QrCodeGeneratorService {
    String getBase64QrCode(QrCode qrCode) throws QrCodeException;

    InputStream getQrCodeStream(QrCode qrCode) throws QrCodeException;
}
