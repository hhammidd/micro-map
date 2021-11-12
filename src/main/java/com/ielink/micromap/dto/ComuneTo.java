package com.ielink.micromap.dto;

public class ComuneTo {
    private Long comuneId;
    private String comuneName1;
    private String comuneName2;
    private String codeComune;
    private long codeFather;

    public ComuneTo() {
    }

    public ComuneTo(Long comuneId, String comuneName1, String comuneName2, String codeComune, long codeFather) {
        this.comuneId = comuneId;
        this.comuneName1 = comuneName1;
        this.comuneName2 = comuneName2;
        this.codeComune = codeComune;
        this.codeFather = codeFather;
    }

    public Long getComuneId() {
        return comuneId;
    }

    public void setComuneId(Long comuneId) {
        this.comuneId = comuneId;
    }

    public String getComuneName1() {
        return comuneName1;
    }

    public void setComuneName1(String comuneName1) {
        this.comuneName1 = comuneName1;
    }

    public String getComuneName2() {
        return comuneName2;
    }

    public void setComuneName2(String comuneName2) {
        this.comuneName2 = comuneName2;
    }

    public String getCodeComune() {
        return codeComune;
    }

    public void setCodeComune(String codeComune) {
        this.codeComune = codeComune;
    }

    public long getCodeFather() {
        return codeFather;
    }

    public void setCodeFather(long codeFather) {
        this.codeFather = codeFather;
    }
}
