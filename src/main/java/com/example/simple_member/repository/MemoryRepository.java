package com.example.simple_member.repository;


import java.util.*;

import com.example.simple_member.domain.Member;
@org.springframework.stereotype.Repository
public class MemoryRepository implements Repository{
    private static Map<Long, Member> store = new HashMap<>();
    private static Long seq=0L;
    @Override
    public Member save(Member member) {
        member.setId(++seq);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long Id) {
        return Optional.ofNullable(store.get(Id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clear(){
        store.clear();
    }
}
