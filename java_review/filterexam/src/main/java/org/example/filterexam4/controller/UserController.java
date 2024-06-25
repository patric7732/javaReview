package org.example.filterexam4.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.filterexam4.entity.User;
import org.example.filterexam4.filter.UserContext;
import org.example.filterexam4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

    @PostMapping("/loginform")
    public String loginform(@ModelAttribute("user") User user, HttpServletResponse response) {

        User byUser = userService.findByUsername(user.getUsername());

        //사용자가 보낸 username과 패스워드가 서버가 원하는 정보랑 일치하는지 확인하고
        //사용자 정보를 유지하게 하면 된다.
        if (byUser != null && user.getPassword().equals(byUser.getPassword())) {
            //실제 서비스에서는 아이디 암호를 검사해서 진행하겠지만...   여기서는 간단하게..
            Cookie cookie = new Cookie("auth", user.getUsername());
            cookie.setPath("/");
            cookie.setHttpOnly(true); // 자바스크립트로는 쿠키에 접근 X

            //이렇게 생성된 쿠키는 클라이언에게 보내져야한다.
            // 쿠키는 같은 이름으로 두개 생성 X
            // 같은 이름으로 다시 들어오면 덮어 씀
            // 이것을 이용해서 로그아웃 구현할 수 있음
            response.addCookie(cookie);
        }

        return "redirect:/welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 큐키를 삭제하면 로그아웃이 되는데, 브라우저의 쿠키는 서버에서 삭제 X
        // 그렇기에 똑같은 이름의 쿠키를 만들어서 보낸다.
        Cookie cookie = new Cookie("auth", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return "redirect:/loginform";
    }

    @GetMapping("/welcome")
    public String welcome() {

//        User user = UserContext.getUser();
//        if (user != null)
//            return "welcome";
//        else
//            return "redirect:/loginform";
        return "welcome";

    }

    @GetMapping("/info")
    public String info(HttpServletRequest request) {
        //아무나 보여줄 수 있는 페이지는 아니고,
        //로그인한 사용자에게만 보여줄거다.
        //쿠키정보를 통해서 알 수 있을거예요.

        User user = UserContext.getUser();
        if (user != null)
            return "info";
        else
            return "redirect:/loginform";
    }
}
