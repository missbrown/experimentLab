package com.bosc.assessment.pn;

import java.util.List;

public abstract class TransitionListener {

    List<Integer> eventCodes;

    public void setEventCodes(List<Integer> eventCodes) {
        this.eventCodes = eventCodes;
    }

    public void handle() {
        for(Integer eventCode: eventCodes) {
            handleEvent(eventCode);
        }
    }

    public abstract void handleEvent(Integer eventCode);
}
