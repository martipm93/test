package com.slashmobility.test.web.endpoint;

import com.slashmobility.test.service.UserService;
import com.slashmobility.test.web.dto.UserDTO;
import com.slashmobility.test.web.endpoint.constants.URLConstants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Operation(summary = "Get a all the users of the data base")
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a user filtering by its id")
    public UserDTO getUser(@PathVariable(URLConstants.ID_PARAM) Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = URLConstants.REGISTRATION_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create a new user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping(value = URLConstants.REGISTRATION_CONFIRMED_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Validate a user who has received the confirmation email with his verification token")
    public UserDTO confirmUser(@RequestParam String token) {
        return userService.enableUser(token);
    }

    @PutMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Update a user data")
    public UserDTO updateUser(@PathVariable(URLConstants.ID_PARAM) Long id,
                              @RequestBody UserDTO userDTO) {
        return userService.update(userDTO, id);
    }

    @GetMapping(value = URLConstants.LOG_OUT_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Log out the session")
    public void logOutSession(HttpServletRequest request, HttpServletResponse response) {
        userService.logOut(request, response);
    }

    @GetMapping(value = URLConstants.RESET_PASSWORD, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Reset the user's password")
    public UserDTO resetPassword(@RequestParam String newPassword) {
        return userService.resetPassword(newPassword);
    }

    @GetMapping(value = URLConstants.LOG_IN_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Log In the session")
    public void logInSession() {
        //Security Config has created the JSESSIONID token in order to log in and authenticate the API Rest requests.
    }

}
