package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.domain.movie.Genre;
import com.javastates.MiniServer.domain.movie.Movie;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieMemoryRespository implements MovieRespository{

    // immutable한 더미 데이터
    Map<UUID, Movie> uuidMovieMap = new HashMap<>(){{
        // 아주 사소한 것도 중복되면 자동화 권장 -갓재현님-
        // 모델 패키지는 안씀, 도메인(DTO) + 폼 패키지를 쓰는 경우는 있음
//        for(int i = 0; i < 5; i++) {
//            put(UUID.randomUUID(), new Movie("movie" + i, Genre.Action, i * 100));
//        }
        put(UUID.randomUUID(), new Movie("극장판 귀멸의 칼날: 무한열차편", Genre.Animation, 100, "https://img.megabox.co.kr/SharedImg/2021/02/01/qDLdOQKdvIeLyniUM7DX567IaJeyJmbv_420.jpg",
                "혈귀로 변해버린 여동생 ‘네즈코’를 인간으로 되돌릴 단서를 찾아 비밀조직 귀살대에 들어간 ‘탄지로.’‘젠이츠’, ‘이노스케’와 새로운 임무 수행을 위해 무한열차에 탑승 후귀살대 최강 검사 염주 ‘렌고쿠’와 합류한다. 달리는 무한열차에서 승객들이 하나 둘 흔적 없이 사라지자숨어있는 식인 혈귀의 존재를 직감하는 ‘렌고쿠’. 귀살대 ‘탄지로’ 일행과 최강 검사 염주 ‘렌고쿠’는어둠 속을 달리는 무한열차에서 모두의 목숨을 구하기 위해예측불가능한 능력을 가진 혈귀와 목숨을 건 혈전을 시작하는데…"));
        put(UUID.randomUUID(), new Movie("컨저링3: 악마가 시켰다", Genre.Horror, 100, "https://img.megabox.co.kr/SharedImg/2021/05/21/740iTHNvhmJgBNh1yNOsPBCQzABfdfgn_420.jpg",
                "1981년, 미국 역사상 최초로 잔혹한 살인사건의 용의자가 악마가 살해하도록 시켰다고 주장하는 초유의 사태가 일어난다! 그리고 사건의 배후에는 악마에게 빙의된 소년이 있었는데…초자연 현상 연구가 워렌 부부의 사건 파일 중 여전히 미스터리로 남아있는 실화!진실 혹은 거짓? 살인사건의 범인, 인간인가 악마인가..."));
        put(UUID.randomUUID(), new Movie("인터스텔라", Genre.SF, 100, "https://upload.wikimedia.org/wikipedia/ko/b/b7/%EC%9D%B8%ED%84%B0%EC%8A%A4%ED%85%94%EB%9D%BC.jpg",
                "우린 답을 찾을 거야, 늘 그랬듯이”세계 각국의 정부와 경제가 완전히 붕괴된 미래가 다가온다. 지난 20세기에 범한 잘못이 전 세계적인 식량 부족을 불러왔고, NASA도 해체되었다. 이때 시공간에 불가사의한 틈이 열리고, 남은 자들에게는 이 곳을 탐험해 인류를 구해야 하는 임무가 지워진다. 사랑하는 가족들을 뒤로 한 채 인류라는 더 큰 가족을 위해, 그들은 이제 희망을 찾아 우주로 간다. 그리고 우린 답을 찾을 것이다. 늘 그랬듯이…"));
        put(UUID.randomUUID(), new Movie("어벤져스: 엔드게임", Genre.Action, 100, "https://upload.wikimedia.org/wikipedia/ko/f/f2/%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4-_%EC%97%94%EB%93%9C%EA%B2%8C%EC%9E%84_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg",
                "인피니티 워 이후 절반만 살아남은 지구마지막 희망이 된 어벤져스 먼저 떠난 그들을 위해 모든 것을 걸었다! 위대한 어벤져스운명을 바꿀 최후의 전쟁이 펼쳐진다!"));
        put(UUID.randomUUID(), new Movie("리눅스: 팽귄의 반란", Genre.Horror, 100, "https://blog.kakaocdn.net/dn/sDcPI/btqOhPwo1X9/8BL6Rfh9FAAXHc18EoWmRk/img.jpg",
                "???"));
        put(UUID.randomUUID(), new Movie("마녀", Genre.Action, 100, "http://t1.daumcdn.net/movie/72e53e2dc1550ae95fe82a73b80d82221a617a10",
                "10년 전 의문의 사고가 일어난 시설에서 홀로 탈출한 후 모든 기억을 잃은 ‘자윤’. 나이도, 이름도 모르는 자신을 거두고 키워준 노부부의 보살핌으로 씩씩하고 밝은 여고생으로 자라났다. 어려운 집안사정을 돕기 위해 상금이 걸린 오디션 프로그램에 출연한 자윤, 방송이 나간 직후부터 의문의 인물들이 그녀 앞에 나타난다. 자윤의 주변을 맴돌며 날카롭게 지켜보는 남자 ‘귀공자’, 그리고 과거 사고가 일어난 시점부터 사라진 아이를 찾던 ‘닥터 백’과 ‘미스터 최’까지 자신은 전혀 기억하지 못하는 그들의 등장으로, 자윤은 혼란에 휩싸이게 되는데...! 그들이 나타난 후 모든 것이 바뀌었다"));
        put(UUID.randomUUID(), new Movie("그래비티", Genre.SF, 100, "https://upload.wikimedia.org/wikipedia/ko/2/28/%EA%B7%B8%EB%9E%98%EB%B9%84%ED%8B%B0_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg",
                "허블 우주망원경을 수리하기 위해 우주를 탐사하던 라이언 스톤 박사는 폭파된 인공위성의 잔해와 부딪히면서 소리도 산소도 없는 우주 한 가운데에 홀로 남겨지는데…"));
        put(UUID.randomUUID(), new Movie("트랜스포머", Genre.SF, 100, "https://upload.wikimedia.org/wikipedia/ko/e/e4/%ED%8A%B8%EB%9E%9C%EC%8A%A4%ED%8F%AC%EB%A8%B8_%EC%98%81%ED%99%94.jpg",
                "《트랜스포머 영화 시리즈》는 2007년 파라마운트 픽처스와 드림웍스가 하스브로와 타카라토미 장난감인 트랜스포머로 기반으로 하여 만든 프랜차이즈이다. 영화 세계관을 의미할때 트랜스포머 시네마틱 유니버스라고도 한다. TF WIKI에서는 \"TYRAN\"이라는 세계관이다."));
        put(UUID.randomUUID(), new Movie("라라랜드", Genre.Romantic, 100, "https://t1.daumcdn.net/movie/0e371de6f342a66143c49af3dd2b204342bbb5aa",
                "꿈을 꾸는 사람들을 위한 별들의 도시 ‘라라랜드’. 재즈 피아니스트 ‘세바스찬’(라이언 고슬링)과 배우 지망생 ‘미아’(엠마 스톤), 인생에서 가장 빛나는 순간 만난 두 사람은 미완성인 서로의 무대를 만들어가기 시작한다."));
    }};

    @Override
    public void save(Movie movie) {
        try {
            uuidMovieMap.put(UUID.randomUUID(), movie);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public Movie findMovieById(UUID uuid) {
        try {
            return uuidMovieMap.get(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Movie> findAllMovie() {
        try {
            ArrayList<Movie> movieArrayList = new ArrayList<>();

            for (UUID key : uuidMovieMap.keySet()) {
                // key를 바탕으로 값을 받아와서 새로운 ArrayList에 넣는다.
                movieArrayList.add(uuidMovieMap.get(key));
            }

            return movieArrayList;
        } catch (Exception e) {
            return null;
        }
    }
}
