package com.javastates.MiniServer.Member;

import com.javastates.MiniServer.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {

    @Test
    @DisplayName("Check Create Member")
    void test1() {
        Member member = new Member("pw", "name", 12);
        assertThat(member.getUserPw()).isEqualTo("pw");
        assertThat(member.getUserName()).isEqualTo("name");
        assertThat(member.getUserAge()).isEqualTo(12);
    }

}
