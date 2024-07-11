package com.tid.StockMaster.controller;
import com.tid.StockMaster.dto.auth.AuthenticationRequest;
import com.tid.StockMaster.dto.auth.AuthenticationResponse;
import com.tid.StockMaster.model.auth.ExtendedUser;
import com.tid.StockMaster.services.auth.ApplicationUserDetailsService;
import com.tid.StockMaster.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.tid.StockMaster.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final ApplicationUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, ApplicationUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(path = "/authenticate")
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);
        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    };
}
