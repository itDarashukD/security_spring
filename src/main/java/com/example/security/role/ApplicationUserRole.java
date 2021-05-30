package com.example.security.role;

import com.example.security.permission.ApplicationUserPermition;
import com.google.common.collect.Sets;

import java.util.Set;
import static com.example.security.permission.ApplicationUserPermition.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet( // give what can do the administrator
            COURSE_READ
            , COURSE_WRITE
            , STUDENT_READ
            , STUDENT_WRITE));

    private final Set<ApplicationUserPermition> permitions;

    ApplicationUserRole(Set<ApplicationUserPermition> permitions) {
        this.permitions = permitions;
    }

    public Set<ApplicationUserPermition> getPermitions() {
        return permitions;
    }
}
