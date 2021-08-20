package com.ca.userqueryapi.dto;


import com.ca.usercore.dto.BaseResponse;
import com.ca.usercore.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public class UserLookupResponse extends BaseResponse {
    private List<User> users;

    public UserLookupResponse(String message) {
        super(message);
    }

    public UserLookupResponse(Flux<User> users) {
        super(null);
        this.users = users.collectList().block();
    }

    public UserLookupResponse(String message, Mono<User> user) {
        super(message);
        users = user.flux().collectList().block();
    }

    public UserLookupResponse(Mono<User> user) {
        super(null);
        users = user.flux().collectList().block();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
