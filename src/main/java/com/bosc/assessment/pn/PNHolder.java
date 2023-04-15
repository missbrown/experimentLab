package com.bosc.assessment.pn;

public class PNHolder {

    private PN pn;

    public void fireAttempt() {
        pn.fireAttempt();
    }

    public void init(PNInitilizer initilizer) {
        PN pn = new PN();
        initilizer.initPN(pn);
        initilizer.reproduceMarking(pn);
        initilizer.registerListener(pn);
        this.pn = pn;
    }
}
