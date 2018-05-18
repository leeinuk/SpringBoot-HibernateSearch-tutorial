package com.hihoyeho.luceneexample.repository;

import com.hihoyeho.luceneexample.domain.Newsroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsroomRepository extends JpaRepository<Newsroom, Integer> {


}
