package com.ca.userqueryapi.dto;


import com.ca.usercore.dto.BaseResponse;
import com.ca.usercore.dto.UserDTO;

public class UserLookupResponse extends BaseResponse {
    private UserDTO userDTO;

    public UserLookupResponse(String message) {
        super(message);
    }

    public UserLookupResponse(String message, UserDTO userDTO_) {
        super(message);
        this.userDTO = userDTO_;
    }

    public UserLookupResponse(UserDTO userDTO_) {
        super(null);
        this.userDTO = userDTO_;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
