package com.example.friendexam.controller;

import com.example.friendexam.domain.Friend;
import com.example.friendexam.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

//    @GetMapping
//    public String friends(Model model){
//        Iterable<Friend> friends = friendService.findAllFriends();
//        model.addAttribute("friends", friends);
//        return "friends/list";
//    }

    // 페이징 처리
    @GetMapping
    public String friends(Model model, @RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Friend> friends = friendService.findAllFriends(pageable);
        model.addAttribute("friends", friends);
        model.addAttribute("currentPage", page);
        return "friends/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "친구 등록 성공");
        friendService.saveFriend(friend);
        return "redirect:/friends";
    }

    // 친구 상세 페이지
    @GetMapping("/{id}")
    public String detailFriend(@PathVariable Long id, Model model) {
        Friend friend = friendService.findFriendByid(id);
        model.addAttribute("friend", friend);
        return "friends/detail";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Friend friend = friendService.findFriendByid(id);
        model.addAttribute("friend", friend);
        return "friends/edit";
    }

    @PostMapping("/edit")
    public String editFriend(@ModelAttribute Friend friend) {
        friendService.saveFriend(friend);
        return "redirect:/friends";
    }

    @GetMapping("/delete/{id}")
    public String deleteFriend(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        friendService.deleteFriendByid(id);
        redirectAttributes.addFlashAttribute("message", "친구가 삭제되었습니다.");
        return "redirect:/friends";
    }

}
