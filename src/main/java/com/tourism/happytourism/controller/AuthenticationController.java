package com.tourism.happytourism.controller;

//import com.example.security.entity.AuthRequest;
//import com.example.security.entity.User;
//import com.example.security.service.CustomUserDetailsService;
//import com.example.security.util.JwtUtil;
import com.tourism.happytourism.entity.AuthRequest;
import com.tourism.happytourism.entity.User;
import com.tourism.happytourism.service.CustomUserDetailsService;
import com.tourism.happytourism.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String welcome() {
        return "Hello World";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

@GetMapping("/findByUserName/{userName}")
    public User findByUserName(@PathVariable("userName") String userName){
//        return  customUserDetailsService.loadUserByUsername(userName);
    return  customUserDetailsService.getUserByUserName(userName);
}
}