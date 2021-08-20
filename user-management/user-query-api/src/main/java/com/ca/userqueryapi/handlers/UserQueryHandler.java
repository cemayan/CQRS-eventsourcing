package com.ca.userqueryapi.handlers;


import com.ca.userqueryapi.dto.UserLookupResponse;
import com.ca.userqueryapi.queries.FindAllUsersQuery;
import com.ca.userqueryapi.queries.FindUserByIdQuery;
import com.ca.userqueryapi.queries.SearchUsersQuery;

public interface UserQueryHandler {
    UserLookupResponse getUserById(FindUserByIdQuery query);
    UserLookupResponse getAllUsers(FindAllUsersQuery query);
}
