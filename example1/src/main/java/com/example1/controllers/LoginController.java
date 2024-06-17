package com.example1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    // 模拟数据库，保存注册的用户信息（实际应用中应该存储在数据库中）
    private final HashMap<String, String> users = new HashMap<>();

    // 显示登录页面
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 处理登录请求
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // 模拟验证用户名和密码
        if (users.containsKey(username) && users.get(username).equals(password)) {
            model.addAttribute("message", "Login successful!");
        } else {
            model.addAttribute("message", "Invalid username or password.");
        }
        return "login";
    }

    // 显示注册页面
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // 处理注册请求
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        // 将注册的用户信息保存到模拟的数据库中
        users.put(username, password);
        // 注册成功后重定向到登录页面
        return "redirect:/login";
    }
}
