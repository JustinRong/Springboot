package com.example.girl.service;

import com.example.girl.domain.Girl;
import com.example.girl.exception.GirlException;
import com.example.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

  @Autowired
  private GirlRepository girlRepository;

  @Transactional
  public void insertTwoGirls() {
    Girl girlA = new Girl();
    girlA.setAge(18);
    girlA.setCupSize("E");
    girlRepository.save(girlA);

    Girl girlB = new Girl();
    girlB.setCupSize("GGGGGG");
    girlB.setAge(20);
    girlRepository.save(girlB);

  }

  public void getAge(Integer id) throws Exception{
   Girl girl = girlRepository.findOne(id);
   Integer age = girl.getAge();
   if (age < 10){
     throw new GirlException(100, "你还在上小学吧");

   }else if (age > 10 && age < 16) {
     throw new GirlException(101, "你可能在上初中");
   }
  }
}
