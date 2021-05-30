package com.example.security.permission;

public enum ApplicationUserPermition {
    STUDENT_READ("student:read"),//create what can do(ability) our roles in this application
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("cource:write");

    private final String permission;

    ApplicationUserPermition(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
