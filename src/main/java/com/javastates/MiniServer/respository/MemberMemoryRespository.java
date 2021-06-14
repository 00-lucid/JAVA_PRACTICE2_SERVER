package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.member.Member;

import java.util.*;

public class MemberMemoryRespository implements MemberRespository{

    // immutable한 더미 데이터
    Map<UUID, Member> uuidMemberMap = new HashMap<>() {{
        for(int i = 0; i < 5; i++) {
            UUID id = UUID.randomUUID();
            System.out.println(id);
            put(id, new Member("id" + i, "pw" + i, "name" + i, i*10));
        }
    }};

    @Override
    public void save(Member member) {
        uuidMemberMap.put(UUID.randomUUID(), member);
    }

    @Override
    public Member findMemberById(UUID uuid) {
        return uuidMemberMap.get(uuid);
    }

    @Override
    public ArrayList<Member> findAllMember() {

        ArrayList<Member> memberArrayList = new ArrayList<>();

        for (UUID key : uuidMemberMap.keySet()) {
            // key를 바탕으로 값을 받아와서 새로운 ArrayList에 넣는다.
            memberArrayList.add(uuidMemberMap.get(key));
        }

        return memberArrayList;
    }
}
