package com.qrcode.generator.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qrcode.generator.exception.QrCodeException;
import com.qrcode.generator.model.QrCode;
import com.qrcode.generator.service.QrCodeGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by grijesh on 7/1/17.
 *
 */

@Service
public class QrCodeGeneratorServiceImpl implements QrCodeGeneratorService {


    @Override
    public String getBase64QrCode(QrCode qrCode) throws QrCodeException {
        try {
            InputStream inputStream = createQrCodeStream(qrCode);
            return "data:image/png;base64," +
                    DatatypeConverter.printBase64Binary(IOUtils.toByteArray(inputStream));
        } catch (WriterException | IOException e) {
            throw new QrCodeException(e.getMessage(), e);
        }
    }

    @Override
    public InputStream getQrCodeStream(QrCode qrCode) throws QrCodeException {
        try {
            return createQrCodeStream(qrCode);
        } catch (WriterException | IOException e) {
            throw new QrCodeException(e.getMessage(), e);
        }
    }

    private InputStream createQrCodeStream(QrCode qrCode) throws WriterException, IOException {
        InputStream inputStream;

        BitMatrix matrix = new MultiFormatWriter().encode(
                qrCode.getInformation(),
                BarcodeFormat.QR_CODE,
                qrCode.getWidth(),
                qrCode.getHeight(),
                getDefaultHints()
        );
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "PNG", stream);
        inputStream = new ByteArrayInputStream(stream.toByteArray());

        return inputStream;
    }

    private Map<EncodeHintType, Object> getDefaultHints(){
        Map<EncodeHintType, Object> map = new HashMap<>();
        map.put(EncodeHintType.ERROR_CORRECTION , ErrorCorrectionLevel.M);
        map.put(EncodeHintType.CHARACTER_SET , "UTF-8");
        return map;
    }


}
