package com.qrcode.web.services.generator.converters;

import com.qrcode.generator.model.QrCode;
import com.qrcode.web.services.generator.model.Pillar;
import com.qrcode.web.services.generator.model.PillarQrCodeInformation;

/**
 * Created by grijesh on 8/1/17.
 */
public class QrCodeModelConverter {

    public static QrCode pillarToQrCode(PillarQrCodeInformation pillar){
        return new QrCode(pillar.getPillar().getPillarName()+"##"+pillar.getPillar().getCapacity(),
                pillar.getImageWidhth(),
                pillar.getImageWidhth());
    }
}
