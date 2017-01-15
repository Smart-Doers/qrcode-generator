package com.qrcode.web.services.generator.validators;

import com.qrcode.web.services.generator.model.PillarQrCodeInformation;
import org.springframework.util.Assert;
import java.util.function.Predicate;

/**
 * Created by jaine03 on 12/01/17.
 */
@SuppressWarnings("unused")
public class QRCodeValidators {

    private static class QRCodeValidatorsUtil {
        public static Predicate<PillarQrCodeInformation> isSizeGreaterThanZero() {
            return qrCode -> qrCode.getImageHeight() > 0 && qrCode.getImageWidhth() > 0;
        }
    }

    public static Validator<PillarQrCodeInformation> getPillarQrCodeValidator() {
        return (qrCodeInfo) -> {
            Assert.notNull(qrCodeInfo,"Input QRCode should not be null");
            Assert.notNull(qrCodeInfo.getPillar(),"Pillar information should not be null");
            Assert.hasLength(qrCodeInfo.getPillar().getPillarName(),"Pillar Name cannot be blank");
            Assert.state(QRCodeValidatorsUtil.isSizeGreaterThanZero().test(qrCodeInfo),"Height and Width should be greater than zero");
        };
    }
}
