package com.project.services.user;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Security.config.JwtService;

import com.project.api.user.dto.AuthenticationRequest;
import com.project.api.user.dto.AuthenticationResponse;
import com.project.api.user.dto.RegisterRequest;
import com.project.database.Entities.user.User;
import com.project.database.Repository.user.UserRepositery;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserRepositery userRepositery;


  /*
   * register => create a user , save it into data base , generate token for that
   * user
   * 
   * encode our password before saving it in database
   */
  public AuthenticationResponse register(RegisterRequest request) {
    User user = User.builder()
        .name(request.getName())
        .gender(request.getGender())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role("user")
        .build();
        if (user!=null)
        {
          User savedUser = userRepositery.save(user);
          String jwtToken = jwtService.generateToken(user);
          return AuthenticationResponse.builder()
          .success(true)
          .token(jwtToken)

          .build();
        }
        else{
          return AuthenticationResponse.builder()
          .success(false)
          .build();
        }

    
    // saveUserToken(savedUser, jwtToken);
   
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
    new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
    // if getEmail or getPassword() is incorrect will throw exeception
    // this line after user authenticated
    // generate token with every sign in
    var user = userRepositery.findByEmail(request.getEmail())
        .orElse(null);

        if (user!= null)
        {
          var jwtToken = jwtService.generateToken(user);
          // revokeAllUserTokens(user)
          return AuthenticationResponse.builder()
              .success(true)
              .token(jwtToken)
              .build();
        }else{
          return AuthenticationResponse.builder()
          .success(false)
          .build();
        }

  
  }

  private void saveUserToken(User user, String jwtToken) {
    // var token = Token.builder()
    // .user(user)
    // .token(jwtToken)
    // .tokenType("BEARER")
    // .expired(false)
    // .revoked(false)
    // .build();
    // tokenRepository.save(token);
  }




  
  public List<User>getAll() {
      return userRepositery.findAll();
  }

  public User addUser(User user) {
      return userRepositery.save(user);
  }

  public User getById(int id) {
      return userRepositery.findById(id).orElse(null);
  }

  public void deleteUser(int id) {
      userRepositery.deleteById(id);
  }

}
