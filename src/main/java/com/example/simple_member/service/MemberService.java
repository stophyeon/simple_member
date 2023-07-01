package com.example.simple_member.service;

import com.example.simple_member.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple_member.domain.Member;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemoryRepository memoryRepository;

    public MemberService(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }


    public Optional<Member> join(Member member){
        Duplicate(member);
        memoryRepository.save(member);
        return memoryRepository.findByName(member.getName());
    }
    public void Duplicate(Member member){
        memoryRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }
    public Optional<Member> findOne(Long id){
        return memoryRepository.findById(id);
    }
    public List<Member> showAll(){
        return memoryRepository.findAll();
    }
    public void ServiceClear(){
        memoryRepository.clear();
    }
}
