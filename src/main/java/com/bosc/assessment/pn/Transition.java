package com.bosc.assessment.pn;

import java.util.List;
import java.util.Map;

public class Transition {

    private Long id;
    private Long pnId;
    private String name;

    private TransitionListener listener;

    public boolean inputFull() {
        for(Long placeId: inputPlaces.keySet()) {
            Place place = inputPlaces.get(placeId);
            if(!place.hasToken()) {
                return false;
            }
        }
        return true;
    }

    public void fire() {
        for(Long placeId: inputPlaces.keySet()) {
            Place place = inputPlaces.get(placeId);
            place.output();
        }
        for(Long placeId: outputPlaces.keySet()) {
            Place place = outputPlaces.get(placeId);
            place.input();
        }
        listener.handle();
    }

    private Map<Long, Place> inputPlaces;
    private Map<Long, Place> outputPlaces;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPnId() {
        return pnId;
    }

    public void setPnId(Long pnId) {
        this.pnId = pnId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
