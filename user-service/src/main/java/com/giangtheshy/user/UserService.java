package com.giangtheshy.user;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
  @Autowired private UserRepository userRepository;
  @Autowired private RestTemplate restTemplate;

  public User register(User user) {
    return userRepository.save(user);
  }

  public ResponseUserDTO getUser(Long id)  {
    Optional<User> byId = userRepository.findById(id);
    User user = byId.get();
    Product product = restTemplate.getForObject(String.format("http://PRODUCT-SERVICE/products/%s", user.getProductId()),
            Product.class);
    return ResponseUserDTO.builder().user(user).product(product).build();
  }
}
