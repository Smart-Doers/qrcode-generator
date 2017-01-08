package com.qrcode.web.services.generator.model;

/**
 * Created by grijesh on 8/1/17.
 */
public class PillarQrCodeInformation {

    private Pillar pillar;

    private int imageWidhth;

    private int imageHeight;

    public Pillar getPillar() {
        return pillar;
    }

    public void setPillar(Pillar pillar) {
        this.pillar = pillar;
    }

    public int getImageWidhth() {
        return imageWidhth;
    }

    public void setImageWidhth(int imageWidhth) {
        this.imageWidhth = imageWidhth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }
}
