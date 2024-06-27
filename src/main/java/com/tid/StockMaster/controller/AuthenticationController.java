package com.tid.StockMaster.controller;
import com.tid.StockMaster.dto.auth.AuthenticationRequest;
import com.tid.StockMaster.dto.auth.AuthenticationResponse;
import com.tid.StockMaster.services.auth.ApplicationUserDetailsService;
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
//@RequestMapping(APP_ROOT + "/auth")
public class AuthenticationController {

//    @Autowired
//    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @PostMapping(path = "authenticate")
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getLogin(),
//                        request.getPassword()
//                )
//        );
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken("Lm_access_token").build());
    };
}
