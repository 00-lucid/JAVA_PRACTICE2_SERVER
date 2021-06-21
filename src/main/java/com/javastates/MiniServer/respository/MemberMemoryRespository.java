package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.member.ConfigVO;
import com.javastates.MiniServer.model.member.Member;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemberMemoryRespository implements MemberRespository{

    // immutable한 더미 데이터
    Map<UUID, Member> uuidMemberMap = new HashMap<>();

    @Override
    public UUID save(Member member) {
        try {
            if (!uuidMemberMap.containsValue(member)) {
                UUID uuid = UUID.randomUUID();
                uuidMemberMap.put(uuid, member);
                return uuid;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Member findMemberById(UUID uuid) {
        try {
            return uuidMemberMap.get(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Member> findAllMember() {
        try {
            ArrayList<Member> memberArrayList = new ArrayList<>();

            for (UUID key : uuidMemberMap.keySet()) {
                // key를 바탕으로 값을 받아와서 새로운 ArrayList에 넣는다.
                memberArrayList.add(uuidMemberMap.get(key));
            }

            return memberArrayList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Member remove(UUID uuid) {
        try {
            return uuidMemberMap.remove(uuid);
        } catch (Exception e) {
            return null;
        }
    }


    public String getToken(String userName, String userPw) {
        try {
            for (Map.Entry entry : uuidMemberMap.entrySet()) {
                String memberStr = entry.getValue().toString();
                if (memberStr.contains(userName) && memberStr.contains(userPw)) {
                    return entry.getKey().toString();
                }
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Member update(UUID uuid, Object object) {
        try {
            Member member = uuidMemberMap.get(uuid);
            member.setUserName(object.toString());
            return member;
        } catch (Exception e) {
            return null;
        }
    }
}
