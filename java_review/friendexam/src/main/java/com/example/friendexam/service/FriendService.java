package com.example.friendexam.service;

import com.example.friendexam.domain.Friend;
import com.example.friendexam.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor // final으로 단독적으로 생성자 주입을 시킴, 인젝션.
public class FriendService {
    private final FriendRepository friendRepository;

    @Transactional(readOnly = true)
    public Iterable<Friend> findAllFriends(){
        return friendRepository.findAll();
    }

    // 친구 등록
    @Transactional
    public Friend saveFriend(Friend friend){
        // Spring data 에서 제공하는 save라는 메서드는 id에 해당하는 값이 이미 존재한다면 수정
        // 없다면 생성함

        return friendRepository.save(friend);
    }

    // id에 해당하는 친구 정보 조회
    @Transactional(readOnly = true)
    public Friend findFriendByid(Long id){
        return friendRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteFriendByid(Long id){
         friendRepository.deleteById(id);
    }

    // 페이징 처리된 친구 목록 조회
    public Page<Friend> findAllFriends(Pageable pageable){
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));
        return friendRepository.findAll(sortedByDescId);
    }
}
