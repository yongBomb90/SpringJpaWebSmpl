package com.bomb.springjpasmpl.modules.study.event;

import com.bomb.springjpasmpl.modules.study.Study;
import lombok.Getter;

@Getter
public class StudyCreatedEvent {

    private Study study;

    public StudyCreatedEvent(Study study) {
        this.study = study;
    }
}
