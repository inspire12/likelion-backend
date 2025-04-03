package com.inspire12.likelionbackend.module.hotplace.domain;

import com.inspire12.likelionbackend.module.hotplace.application.HotPlaceRankingService;
import com.inspire12.likelionbackend.module.hotplace.application.HotPlaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
class HotPlaceTest {

    @Autowired
    private HotPlaceService hotPlaceService;

    @Test
    void getRankings() {
    }

    @Test
    void 사용자가_입력한_별점을_모아_각_맛집의_평균별점을_계산() {

        assertFalse(true);
    }

    @Test
    void 계산된_평균_별점을_토대로_랭킹_서비스_제공() {
        assertFalse(true);
    }

    @Test
    @DisplayName("별점 0.5점도 허용할 것인지?")
    void 별점_자연수일때만_허용() {
        // given
        double score = 1.5;
        HotPlace hotPlace = new HotPlace(score);
        // 의미로는 given.. 실행될때 해당 로직을 거치면 함수를 들어가지말고 thenReturn 값을 내보냄

        // when 실행
        boolean validate = hotPlace.validate();
        // then
        assertFalse(validate);
    }

    @Test
    @DisplayName("별점 0.5점도 허용할 것인지?")
    void 별점_범위인지() {
        // given
//        HotPlace hotPlace = new HotPlace();

        // when

        // then
    }
}