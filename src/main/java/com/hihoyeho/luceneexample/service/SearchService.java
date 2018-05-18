package com.hihoyeho.luceneexample.service;

import com.hihoyeho.luceneexample.domain.Newsroom;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Service
public class SearchService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    /**
     * 인덱스 재생성
     * @throws InterruptedException
     */
    public void buildSearchIndex() throws InterruptedException {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();
    }

    /**
     * 뉴스룸 검색
     * @param keyword 검색 키워드
     * @return 뉴스룸 목록
     */
    public List<Newsroom> searchNewsroom(String keyword) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                .forEntity(Newsroom.class)
                .get();
        Query query = queryBuilder.keyword()
                .onFields("title", "content")
                .matching(keyword)
                .createQuery();
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Newsroom.class);
        List<Newsroom> newsrooms = (List<Newsroom>) fullTextQuery.getResultList();
        return newsrooms;
    }

}
