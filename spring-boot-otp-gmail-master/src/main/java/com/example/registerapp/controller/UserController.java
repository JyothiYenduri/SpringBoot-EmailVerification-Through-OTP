package com.example.registerapp.controller;

import com.example.registerapp.dto.LoginDto;
import com.example.registerapp.dto.RegisterDto;
import com.example.registerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
    return new ResponseEntity<>(userService.register(registerDto), HttpStatus.OK);
  }

  @PutMapping("/verify-account")
  public ResponseEntity<String> verifyAccount(@RequestParam String email,
      @RequestParam String otp) {
    return new ResponseEntity<>(userService.verifyAccount(email, otp), HttpStatus.OK);
  }
  @PutMapping("/regenerate-otp")
  public ResponseEntity<String> regenerateOtp(@RequestParam String email) {
    return new ResponseEntity<>(userService.regenerateOtp(email), HttpStatus.OK);
  }
  @PutMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
    return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
  }
  @PutMapping("/forgot-password")
  public ResponseEntity<String> forgotPassword(@RequestParam String email){
	  return new ResponseEntity<>(userService.forgotPassword(email),HttpStatus.OK);
  }
 @PutMapping("/set-password")
  public ResponseEntity<String> setPassword(@RequestParam String email, @RequestHeader String newPassword){
	  return new ResponseEntity<>(userService.setPassword(email,newPassword),HttpStatus.OK);
  }
 @PostMapping("/logout")
 public RedirectView logout() {
	 return new RedirectView("/login");
 }
}
