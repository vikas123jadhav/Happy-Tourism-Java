package com.tourism.happytourism.controller;


import com.tourism.happytourism.entity.AuthRequest;
import com.tourism.happytourism.entity.User;
import com.tourism.happytourism.model.AuthenticationResponse;
import com.tourism.happytourism.model.UserDto;
import com.tourism.happytourism.service.CustomUserDetailsService;
import com.tourism.happytourism.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
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
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("invalid username/password");
        }
        String token = jwtUtil.generateToken(authRequest.getUserName());
        System.out.println(token);
         return ResponseEntity.ok(new AuthenticationResponse(token));
    }

@GetMapping("/current-user/{userName}")
    public UserDto findByUserName(@PathVariable("userName") String userName){
//        return  customUserDetailsService.loadUserByUsername(userName);
    return  customUserDetailsService.getUserByUserName(userName);
}
}