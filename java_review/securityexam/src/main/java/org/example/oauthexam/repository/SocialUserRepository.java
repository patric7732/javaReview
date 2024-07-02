package org.example.oauthexam.repository;

import java.util.Optional;
import org.example.oauthexam.domain.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
    Optional<SocialUser> findBySocialIdAndProvider(String socialId, String provider);
}
