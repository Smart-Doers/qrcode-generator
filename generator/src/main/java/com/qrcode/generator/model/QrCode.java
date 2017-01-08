package com.qrcode.generator.model;

/**
 * Created by grijesh on 7/1/17.
 */

public class QrCode {

    private String information;

    private int width;

    private int height;

    public QrCode(String information, int width, int height) {
        this.information = information;
        this.width = width;
        this.height = height;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrCode qrCode = (QrCode) o;

        if (width != qrCode.width) return false;
        if (height != qrCode.height) return false;
        return information != null ? information.equals(qrCode.information) : qrCode.information == null;

    }

    @Override
    public int hashCode() {
        int result = information != null ? information.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "QrCode{" +
                "information='" + information + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
