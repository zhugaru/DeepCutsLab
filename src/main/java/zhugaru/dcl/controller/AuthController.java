package zhugaru.dcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zhugaru.dcl.entity.UserEntity;
import zhugaru.dcl.service.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String newUser(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }


    @PostMapping
    public String saveNewUser(@ModelAttribute("user") UserEntity user) {
        userService.saveUser(user);
        return "redirect:/auth/profile";
    }
}