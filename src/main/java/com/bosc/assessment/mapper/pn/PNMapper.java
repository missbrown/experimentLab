package com.bosc.assessment.mapper.pn;

import com.bosc.assessment.pn.entity.*;

import java.util.List;

public interface PNMapper {

    PNEntity getEntity(Integer businessCode);
    List<PlaceEntity> placeList(long pnId);
    List<TransitionEntity> transitionList(long pnId);
    List<PNIOEntity> ioList(long pnId);
    List<PNMarkEntity> markList(long pnId);
    List<TransitionEventEntity> transitionEventList(long pnId);

    void createPN(PNEntity entity);
    void createPlace(PlaceEntity entity);
    void createTransition(TransitionEntity entity);
    void createIO(List<PNIOEntity> list);
    void saveMark(List<PNMarkEntity> list);
    void saveTransitionEvent(TransitionEventEntity entity);
}
