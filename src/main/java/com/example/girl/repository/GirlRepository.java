package com.example.girl.repository;

import com.example.girl.domain.Girl;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepository extends JpaRepository<Girl,Integer>{

  //通过年龄进行查询
  public List<Girl> findByAge(Integer age);
}
