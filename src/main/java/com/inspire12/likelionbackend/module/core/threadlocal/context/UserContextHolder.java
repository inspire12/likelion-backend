
package com.inspire12.likelionbackend.module.core.threadlocal.context;

public class UserContextHolder {

    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void setUser(String username) {
        currentUser.set(username);
    }

    public static String getUser() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }

    // Spring Security에서 인증정보 가져오기
    public static String getAuthenticatedUsername() {

        return "Anonymous";
    }
}