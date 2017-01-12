package com.qrcode.web.services.generator.converters;

import com.qrcode.generator.model.QrCode;
import com.qrcode.web.services.generator.model.PillarQrCodeInformation;
import com.qrcode.web.services.generator.validators.QRCodeValidators;
import com.qrcode.web.services.generator.validators.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by grijesh on 8/1/17.
 */
public class QrCodeModelConverter {

    private static transient Logger logger = LoggerFactory.getLogger(QrCodeModelConverter.class);

    public static QrCode pillarToQrCode(PillarQrCodeInformation pillar){
        Validator<PillarQrCodeInformation> validator = QRCodeValidators.getPillarQrCodeValidator();
        logger.debug("PillarQrCode Validator : {}",validator);
        validator.valid(pillar);

        return new QrCode(pillar.getPillar().getPillarName()+"##"+pillar.getPillar().getCapacity(),
                pillar.getImageWidhth(),
                pillar.getImageWidhth());
    }
}
