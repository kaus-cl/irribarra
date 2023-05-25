package com.globallogic.irribarra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.irribarra.dom.UserDOM;
import com.globallogic.irribarra.model.User;
import com.globallogic.irribarra.security.JwtUtil;
import com.globallogic.irribarra.service.UserService;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Object> process(@Valid @RequestBody UserDOM userdata) {
        User user = userdata.toUser();
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, false, false, false, roles);
        String token = jwtUtil.generateToken(ud);
        user.setToken(token);
        userService.create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
