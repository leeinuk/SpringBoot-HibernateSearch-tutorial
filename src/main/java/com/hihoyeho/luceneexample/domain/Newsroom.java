package com.hihoyeho.luceneexample.domain;

import org.apache.lucene.analysis.ko.KoreanFilterFactory;
import org.apache.lucene.analysis.ko.KoreanTokenizerFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.*;

@Entity(name = "newsroom")
@Indexed
@AnalyzerDef(name = "koreanAnalyzer"
        , tokenizer = @TokenizerDef(factory = KoreanTokenizerFactory.class)
        , filters = { @TokenFilterDef(factory = KoreanFilterFactory.class)})
public class Newsroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "newsroom_no")
    private Integer newsroomNo; //뉴스룸 고유번호

    @Column(name = "link")
    private String link; //링크

    @Column(name = "title")
    @Field
    @Analyzer(definition = "koreanAnalyzer")
    private String title; //제목

    @Column(name = "content")
    @Field
    @Analyzer(definition = "koreanAnalyzer")
    private String content; //본문

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getNewsroomNo() {
        return newsroomNo;
    }

    public void setNewsroomNo(Integer newsroomNo) {
        this.newsroomNo = newsroomNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
