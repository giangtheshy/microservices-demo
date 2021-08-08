package com.giangtheshy.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

  @GetMapping("/userServiceFallBack")
  public String userServiceFallBackMethod() {
    return "User service taking longer than expected. Try later again!";
  }

  @GetMapping("/productServiceFallBack")
  public String productServiceFallBackMethod() {
    return "Product service taking longer than expected. Try later again!";
  }
}
