package com.example.simple_member.repository;


import com.example.simple_member.domain.Member;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository {
    Member save(Member member);

    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String name);

    List<Member> findAll();

}
