package com.ca.userqueryapi.handlers;


import com.ca.usercore.mapper.UserMapper;
import com.ca.userqueryapi.dto.UserLookupResponse;
import com.ca.userqueryapi.queries.FindAllUsersQuery;
import com.ca.userqueryapi.queries.FindUserByIdQuery;
import com.ca.userqueryapi.queries.SearchUsersQuery;
import com.ca.userqueryapi.repositories.UserRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserQueryHandlerImpl implements UserQueryHandler {
    private final UserRepository userRepository;

    @Autowired
    public UserQueryHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryHandler
    @Override
    public Mono getUserById(FindUserByIdQuery query) {
        var user = userRepository.findById(query.getId());
        return  user.map(x-> UserMapper.INSTANCE.userToUserDTO(x));
    }

    @QueryHandler
    @Override
    public Flux getAllUsers(FindAllUsersQuery query) {
        var users = userRepository.findAll();
        return users.map(x-> UserMapper.INSTANCE.userToUserDTO(x));
    }
}
