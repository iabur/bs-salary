package com.bs23.esmpanel.service;

import com.bs23.esmpanel.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseService {
    protected User getLoggedInUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
