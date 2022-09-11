package tracker.com.controller;


import tracker.com.controller.model.JwtResponse;
import tracker.com.controller.model.LoginRequest;
import tracker.com.entity.User;
import tracker.com.repository.UserRepository;
import tracker.com.security.jwt.JWTFilter;
import tracker.com.security.jwt.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final TokenProvider tokenProvider;
    private final UserRepository userRepository;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthController(TokenProvider tokenProvider, UserRepository userRepository, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        boolean rememberMe = request.getRememberMe() != null && request.getRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        User user = userRepository.findOneWithAuthoritiesByLogin(request.getUsername()).get();
        return new ResponseEntity<>(new JwtResponse(jwt, Long.valueOf(user.getId()), user.getLogin(), user.getEmail(), user.getAuthorities()), httpHeaders, HttpStatus.OK);

    }

}