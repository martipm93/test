package com.slashmobility.test.web.endpoint;

import com.slashmobility.test.service.UserService;
import com.slashmobility.test.web.dto.UserDTO;
import com.slashmobility.test.web.endpoint.constants.URLConstants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLConstants.USER_ROOT)
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void newUser(@RequestBody UserDTO userDTO) {
        userService.newUser(userDTO);
    }

}
