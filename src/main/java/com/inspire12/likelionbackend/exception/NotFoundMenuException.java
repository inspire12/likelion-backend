package com.inspire12.likelionbackend.exception;

public class NotFoundMenuException extends RuntimeException {

    public NotFoundMenuException(final Long menuId) {
        super("메뉴를 찾을 수 없습니다. menuId: " + menuId);
    }
}
