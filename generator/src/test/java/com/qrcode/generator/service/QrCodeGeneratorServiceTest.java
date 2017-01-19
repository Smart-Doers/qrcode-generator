package com.qrcode.generator.service;

import com.qrcode.generator.model.QrCode;
import com.qrcode.generator.service.impl.QrCodeGeneratorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Created by grijesh on 7/1/17.
 */

public class QrCodeGeneratorServiceTest {

    QrCodeGeneratorService service;

    @BeforeEach
    public void setup() {
        service = new QrCodeGeneratorServiceImpl();
    }

    @Test
    @DisplayName("Should return Base64 binary string version of QR-Code")
    void should_return_base64_qrCode() {
        //Given
        String information = "Hello World";
        QrCode qrCode = new QrCode(information, 40, 40);

        //When
        String base64QrCode = service.getBase64QrCode(qrCode);

        //Then
        assertNotNull(base64QrCode, "QR code should not be null");
    }

    @Test
    @DisplayName("Should return Qr-Code Stream")
    void should_return_stream() {
        //Given
        String information = "Hello World";
        QrCode qrCode = new QrCode(information, 40, 40);

        //When
        InputStream inputStream = service.getQrCodeStream(qrCode);

        //Then
        assertNotNull(inputStream, () -> "Stream should not be empty");
    }
}
