package com.hihoyeho.luceneexample.service;


import com.hihoyeho.luceneexample.domain.Newsroom;
import com.hihoyeho.luceneexample.repository.NewsroomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTest {

    final static Logger log = LoggerFactory.getLogger(SearchServiceTest.class);

    @Autowired
    private NewsroomRepository newsroomRepository;

    @Autowired
    private SearchService searchService;

    @Before
    public void create() throws InterruptedException {
        Newsroom newsroom = new Newsroom();
        newsroom.setTitle("5월 14일 (월) 뉴스룸 다시보기 2부");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634630");
        newsroom.setContent("뉴스룸의 앵커브리핑을 시작하겠습니다.소리가 없는 것은 차라리 다행이었습니다.38년 만에 소개된 미공개 영상.흑백의 화면만이 남아있을 뿐.음향이 담겨있지 않은 그 영상 속에는 모진 그날을 견뎌낸 5월, 광주의");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("5월 14일 (월) 뉴스룸 다시보기 1부");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634631");
        newsroom.setContent("한국과 같은 번영을 약속한다&hellip;북한사람들도 고기를 먹고 살게 해주겠다&hellip;주말사이에 미국에서 나온 이런 얘기들은 북한을 움직일 것인가. 듣기에 따라서는 만감이 교차할 수 있는 말들인데, 이런 말들");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("클로징 (BGM : Five Years - Mychael Danna)");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634585");
        newsroom.setContent("15일 오전, 미세먼지 수치가 나쁨 수준입니다.낮 기온은 30도 안팎까지 올라 덥습니다.끝나고 < 소셜라이브 > 가 진행되겠습니다. 오늘은 싱가포르에 가있는 김태영 기자와 박현주 기자를 연결해서 싱가포르에서 소");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("[비하인드 뉴스] 의원들만으론 부족했나…총력 '대리' 투쟁");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634586");
        newsroom.setContent("[앵커]비하인드 뉴스를 시작하겠습니다. 박성태 기자가 나와 있습니다. 열죠. [기자]첫 키워드는 < 총력 '대리' 투쟁 > 으로 잡았습니다.[앵커]누가 누구를 대리합니까?[기자]보좌관들이 대리 투쟁에 동원이 된 정");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("[밀착카메라] 국립공원 지정 50년 계룡산…주변 난개발에 몸살");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634590");
        newsroom.setContent("[앵커]국립공원으로 지정된 지 50년째 충남 계룡산에 밀착카메라가 다녀왔습니다. 매년 150만 명 정도의 시민들이 기대를 안고 찾는 곳입니다. 그런데 밀착카메라를 만난 주민들은 \"다 망한 동네 같다\", \"유령도시");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("[뉴스브리핑] 바다에 뛰어든 여성 구조…두 경찰관에 '표창'");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634591");
        newsroom.setContent("1. 바다에 뛰어든 여성 구조&hellip;두 경찰관에 '표창'구명튜브를 맨 경찰이 바다에 빠져 있는 여성을 구합니다. 그제(12일) 새벽 2시 25분쯤 부산 우동의 한 방파제에서 이 여성이 갑자기 바다로 뛰어들었습니다.");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("8살 딸까지 동원한 일가족 연쇄 자폭테러…\"IS 동조 세력\"");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634592");
        newsroom.setContent("[앵커]싱가포르와 인접한 나라지요. '인도네시아'에서 어린 아이를 포함한 일가족들이 하루 사이에 잇따라 자살 폭탄 테러를 벌였습니다. 교회와 경찰을 상대로 자살 테러를 감행한 일가족에는 8살, 9살의 소녀들도");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("북핵·지진보다 불안한 건 '미세먼지'…사회문제보다도 높아");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634595");
        newsroom.setContent("[앵커]오늘(14일)도 전국이 뿌연 하늘이었지요. 우리 국민들이 지진이나 북한의 핵보다도 더 불안해하는 것, 미세먼지로 나타났습니다.오효정 기자입니다. [기자][김세환/서울 상도동 : 창문 열어놓으면 먼지가 뿌");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("담뱃갑 '경고그림' 수위 높인다…궐련형 전자담배에도 부착");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634596");
        newsroom.setContent("[앵커]연말쯤 담뱃갑에 부착된 경고그림이 바뀝니다. 2년 만인데 수위가 한층 높아집니다. 특히 그동안 예외로 놔뒀던 궐련형 전자담배에도 경고그림이 붙습니다. 반발도 만만치 않지만 몸에 덜 해로운 담배는 없다");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
        newsroom.setTitle("[팩트체크] 풍계리 핵실험장 폭파하면 방사능 유출?");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634587");
        newsroom.setContent("[조선중앙TV (지난 12일) : 핵시험장 폐기를 투명성 있게 보여주기 위하여 국내 언론기관들은 물론 국제기자단의 현지 취재활동을 허용할 용의가 있다. 중국, 러시아, 미국, 영국, 남조선에서 오는 기자들로 한정시");
        newsroomRepository.save(newsroom);

        searchService.buildSearchIndex();
    }

    @Test
    public void searchNewsroomTest() {
        String keyword = "미세먼지";

        List<Newsroom> newsrooms = searchService.searchNewsroom(keyword);
        for(Newsroom newsroom : newsrooms) {
            log.info("\n제목 : {}\n링크 : {}\n내용 : {} \n---------------------------------\n"
                    , newsroom.getTitle()
                    , newsroom.getLink()
                    , newsroom.getContent());
        }
    }

}
