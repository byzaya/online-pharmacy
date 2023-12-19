package org.example.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.controller.BaseController;
import org.example.dto.user.UserAccountDto;
import org.example.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
@RequiredArgsConstructor
public class UserController extends BaseController {

  private final UserService userService;

  @GetMapping("/{user_id}")
  public ResponseEntity<?> getItemInfo(@PathVariable(value = "user_id") Long userId) {
    return ResponseEntity.ok(UserAccountDto.fromUserAccount(userService.getUserInfo(userId)));
  }
}