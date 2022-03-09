package com.slashmobility.test.web.endpoint;

import com.slashmobility.test.service.UserService;
import com.slashmobility.test.web.dto.UserDTO;
import com.slashmobility.test.web.endpoint.constants.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLConstants.USER_ROOT)
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public UserDTO getUser(@PathVariable(URLConstants.ID_PARAM) Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = URLConstants.REGISTRATION_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping(value = URLConstants.REGISTRATION_CONFIRMED_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public UserDTO confirmUser(@RequestParam String token) {
        return userService.enableUser(token);
    }

    @PutMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public UserDTO updateUser(@PathVariable(URLConstants.ID_PARAM) Long id,
                              @RequestBody UserDTO userDTO) {
        return userService.update(userDTO, id);
    }

}
