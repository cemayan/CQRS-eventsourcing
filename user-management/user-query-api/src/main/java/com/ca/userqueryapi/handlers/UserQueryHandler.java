package com.ca.userqueryapi.handlers;


import com.ca.usercore.dto.UserDTO;
import com.ca.userqueryapi.dto.UserLookupResponse;
import com.ca.userqueryapi.queries.FindAllUsersQuery;
import com.ca.userqueryapi.queries.FindUserByIdQuery;
import com.ca.userqueryapi.queries.SearchUsersQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserQueryHandler {
    Mono<UserDTO> getUserById(FindUserByIdQuery query);
    Flux getAllUsers(FindAllUsersQuery query);
}
