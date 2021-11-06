package com.bomb.springjpasmpl.modules.study.event;

import com.bomb.springjpasmpl.modules.study.Study;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StudyUpdateEvent {

    private final Study study;

    private final String message;

}
