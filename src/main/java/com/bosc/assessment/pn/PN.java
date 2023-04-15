package com.bosc.assessment.pn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PN {

    private Long id;
    private String name;
    private Integer businessCode;
    private Map<Long, Place> placeMap;
    private Map<Long, Transition> transitionMap;

    Lock fireLock = new ReentrantLock();

    public void fireAttempt() {
        fireLock.lock();
        try {
            List<Transition> fireList = new ArrayList<>();
            for(Long transitionId: transitionMap.keySet()) {
                Transition transition = transitionMap.get(transitionId);
                if(transition.inputFull()) {
                    fireList.add(transition);
                }
            }
            for(Transition transition: fireList) {
                transition.fire();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            fireLock.unlock();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(Integer businessCode) {
        this.businessCode = businessCode;
    }

    public Place getPlace(Long id) {
        return placeMap.get(id);
    }

    public Transition getTransition(Long id) {
        return transitionMap.get(id);
    }

    public void setPlaceMap(Map<Long, Place> placeMap) {
        this.placeMap = placeMap;
    }
}
