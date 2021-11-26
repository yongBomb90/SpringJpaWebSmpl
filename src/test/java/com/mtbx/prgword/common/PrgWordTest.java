package com.mtbx.prgword.common;



import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PrgWordTest {

    @BeforeAll
    public void beforeTestClass() {
        System.out.println("============================================");
        System.out.println("===============START BOMB TEST =============");
        System.out.println("============================================");
    }

    @AfterAll
    public void afterTestClass() {
        System.out.println("============================================");
        System.out.println("===============END  BOMB TEST =============");
        System.out.println("============================================");
    }




}
