package com.qrcode.web.services.generator.controllers;

import com.qrcode.generator.exception.QrCodeException;
import com.qrcode.generator.model.QrCode;
import com.qrcode.generator.service.QrCodeGeneratorService;
import com.qrcode.web.services.generator.model.PillarQrCodeInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

import static com.qrcode.web.services.generator.converters.QrCodeModelConverter.pillarToQrCode;

/**
 * Created by grijesh on 7/1/17.
 *
 */
@RestController
@RequestMapping("/qrcode")
@SuppressWarnings("unused")
public class QrCodeGenerationController {

    @Autowired
    private QrCodeGeneratorService qrCodeGeneratorService;
    private static transient Logger logger = LoggerFactory.getLogger(QrCodeGenerationController.class);

    @RequestMapping(value = "/base64", method = RequestMethod.POST)
    public ResponseEntity<String> getQrCodeBase64(@RequestBody PillarQrCodeInformation pillar) {
        String qrCodeBase64;
        try {
            QrCode qrCode = pillarToQrCode(pillar);
            qrCodeBase64 = qrCodeGeneratorService.getBase64QrCode(qrCode);
        } catch (QrCodeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(qrCodeBase64);
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ResponseEntity<InputStreamResource> getQrCodeImage(@RequestBody PillarQrCodeInformation pillar) {
        InputStreamResource resource;
        try {
            QrCode qrCode = pillarToQrCode(pillar);
            InputStream inputStream = qrCodeGeneratorService.getQrCodeStream(qrCode);
            resource = new InputStreamResource(inputStream);
        } catch (QrCodeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
