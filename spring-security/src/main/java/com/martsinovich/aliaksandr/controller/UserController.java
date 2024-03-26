package com.martsinovich.aliaksandr.controller;

import com.martsinovich.aliaksandr.model.BlockedUser;
import com.martsinovich.aliaksandr.model.dto.SecretDto;
import com.martsinovich.aliaksandr.service.CacheService;
import com.martsinovich.aliaksandr.service.SecretGeneratorService;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  private final CacheService<BlockedUser> cacheService;

  private final SecretGeneratorService secretGeneratorService;

  public UserController(CacheService<BlockedUser> cacheService,
      SecretGeneratorService secretGeneratorService) {
    this.cacheService = cacheService;
    this.secretGeneratorService = secretGeneratorService;
  }

  @GetMapping("/info")
  public String info() {
    return "info";
  }

  @GetMapping("/about")
  public String about() {
    return "about";
  }

  @GetMapping("/admin")
  public String admin() {
    return "admin";
  }

  @GetMapping("/login")
  public String login(ModelMap model, @RequestParam("error") Optional<String> error) {
    error.ifPresent(e -> model.addAttribute("error", e));

    return "login";
  }

  @GetMapping("/logoutSuccess")
  public String logout() {
    return "logout";
  }

  @GetMapping("/blocked")
  public String blocked(Model model) {
    final var blockedUsers = cacheService.getAll();

    if (!blockedUsers.isEmpty()) {
      model.addAttribute("blockedUsers", blockedUsers);
    }

    return "blocked";
  }

  @PreAuthorize("hasAuthority('STANDARD')")
  @GetMapping({"/secret", "/secret/{token}"})
  public String secret(Model model, @PathVariable(required = false) Optional<String> token) {
    model.addAttribute("secretDto", new SecretDto());
    if (token.isPresent()) {
      final var secret = secretGeneratorService.provide(token.get());
      if (Objects.nonNull(secret)) {
        model.addAttribute("secretFromUser", secret.getEmail());
        model.addAttribute("secret", secret.getSecret());
      } else {
        model.addAttribute("secretError", "Secret is not available");
      }
    }

    return "secret";
  }

  @PostMapping("/secret-generate")
  public String secretGeneration(@ModelAttribute SecretDto secretDto, Model model,
      @AuthenticationPrincipal User user) {
    final var url = secretGeneratorService.generate(user.getUsername(), secretDto.getSecret());
    model.addAttribute("secretUrl", url);

    return "secret";
  }
}
