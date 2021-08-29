package com.ca.musiccore.dto.user;

import com.ca.musiccore.dto.BaseResponse;


public class UserLookupResponse extends BaseResponse {
    private UserDTO userDTO;

    public UserLookupResponse(String message) {
        super(message);
    }

    public UserLookupResponse(String message, UserDTO userDTO_) {
        super(message);
        userDTO = userDTO_;
    }

    public UserLookupResponse(UserDTO userDTO_) {
        super(null);
        userDTO = userDTO_;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
