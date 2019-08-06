package com.dnight.itext;

/**
 * @author ZHONGPENG769
 * @date 2019/8/1
 */
public class Extension {

    private String oid;

    private boolean critical;

    private byte[] value;

    public String getOid() {
        return oid;
    }

    public byte[] getValue() {
        return value;
    }

    public boolean isCritical() {
        return critical;
    }

}
