package com.qrcode.generator.service;

import com.qrcode.generator.exception.QrCodeException;
import com.qrcode.generator.model.QrCode;
import com.qrcode.generator.service.impl.QrCodeGeneratorServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


/**
 * Created by grijesh on 7/1/17.
 */

public class QrCodeGeneratorServiceTest {

    QrCodeGeneratorService service;

    @Before
    public void setup() {
        service = new QrCodeGeneratorServiceImpl();
    }

    @Test
    public void should_return_base64_qrCode() {
        //Given
        String information = "Hello World";
        QrCode qrCode = new QrCode(information, 40, 40);

        //When
        String base64QrCode = null;
        try {
            base64QrCode = service.getBase64QrCode(qrCode);
        } catch (QrCodeException e) {
            fail();
        }

        //Then
        assertNotNull(base64QrCode);
    }

    @Test
    public void should_return_stream() {
        //Given
        String information = "Hello World";
        QrCode qrCode = new QrCode(information, 40, 40);

        //When
        InputStream inputStream = service.getQrCodeStream(qrCode);

        //Then
        assertNotNull(inputStream);
    }
}
