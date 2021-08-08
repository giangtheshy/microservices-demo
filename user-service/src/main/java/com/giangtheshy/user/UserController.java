package com.giangtheshy.user;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
  @Autowired private UserService userService;

  @PostMapping("/")
  public User register(@RequestBody User user) {
    log.info("register user");
    return userService.register(user);
  }

  @GetMapping("/{id}")
  public ResponseUserDTO getUser(@PathVariable Long id) {

    return userService.getUser(id);
  }
}
