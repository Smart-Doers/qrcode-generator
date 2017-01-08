package com.qrcode.web.services.generator.converters;

import com.qrcode.generator.model.QrCode;
import com.qrcode.web.services.generator.model.Pillar;
import com.qrcode.web.services.generator.model.PillarQrCodeInformation;
import com.qrcode.web.services.generator.validators.Validator;
import org.springframework.util.Assert;

import java.util.function.Predicate;

/**
 * Created by grijesh on 8/1/17.
 */
public class QrCodeModelConverter {

    private static Predicate<PillarQrCodeInformation> isSizeGreaterThanZero() {
        return p -> p.getImageHeight() > 0 && p.getImageWidhth() > 0;
    }

    public static QrCode pillarToQrCode(PillarQrCodeInformation pillar){
        Validator<PillarQrCodeInformation> validator = (qrCodeInfo) -> {
            Assert.notNull(qrCodeInfo, "Input should not be null");
            Assert.notNull(qrCodeInfo.getPillar(), "Please enter pillar Details");
            Assert.hasLength(qrCodeInfo.getPillar().getPillarName(), "Pillar name cannot be blank");
            Assert.state(isSizeGreaterThanZero().test(qrCodeInfo)," Height & Width should be greater than zero");
        };

        validator.valid(pillar);

        return new QrCode(pillar.getPillar().getPillarName()+"##"+pillar.getPillar().getCapacity(),
                pillar.getImageWidhth(),
                pillar.getImageWidhth());
    }
}
