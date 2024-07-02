package org.example.jwtexam.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jwtexam.domain.RefreshToken;
import org.example.jwtexam.domain.Role;
import org.example.jwtexam.domain.User;
import org.example.jwtexam.dto.UserLoginResponseDto;
import org.example.jwtexam.jwt.util.JwtTokenizer;
import org.example.jwtexam.security.dto.UserLoginDto;
import org.example.jwtexam.service.RefreshTokenService;
import org.example.jwtexam.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserLoginDto userLoginDto,
                                BindingResult bindingResult, HttpServletResponse response){
        //username,password가 null일때..(정해진 형식에 맞지 않을때..)
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        //일단은 username과 password 값을 잘 받아왔다면..
        //우리 서비스에 가입한 사용자 인지...  요거 알아봐요..
        User user = userService.findByUsername(userLoginDto.getUsername());
        //요청정보에서 얻어온 비밀번호와 우리 서비스가 갖고있는 비밀번호가 일치하는지확인.
        if(!passwordEncoder.matches(userLoginDto.getPassword(),user.getPassword())) {
            //비밀번호가 일치하지않을때!!
            return new ResponseEntity("비밀번호가 올바르지 않습니다.",HttpStatus.UNAUTHORIZED);
        }
        //여기까지 왔다는것은..  유저도있고, 비밀번호도 맞다.
        //롤객체를 꺼내서 롤의 이름만 리스트로 얻어온다.
        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());

        //토큰 발급
        String accessToken = jwtTokenizer.createAccessToken(
                user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);
        String refreshToken = jwtTokenizer.createRefreshToken(
                user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);

        //리프레시토큰을 디비에 저장.
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setValue(refreshToken);
        refreshTokenEntity.setUserId(user.getId());

        refreshTokenService.addRefreshToken(refreshTokenEntity);

        //응답으로 보낼 값들을 준비해요.
        UserLoginResponseDto loginResponseDto = UserLoginResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .name(user.getName())
                .build();

        Cookie accessTokenCookie = new Cookie("accessToken",accessToken);
        accessTokenCookie.setHttpOnly(true);  //보안 (쿠키값을 자바스크립트같은곳에서는 접근할수 없어요.)
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.ACCESS_TOKEN_EXPIRE_COUNT/1000)); //30분 쿠키의 유지시간 단위는 초 ,  JWT의 시간단위는 밀리세컨드

        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.REFRESH_TOKEN_EXPIRE_COUNT/1000)); //7일

        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);

        return new ResponseEntity(loginResponseDto, HttpStatus.OK);
    }
}
