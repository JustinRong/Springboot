package com.example.girl.service;

import com.example.girl.domain.Girl;
import com.example.girl.enums.ResultEnum;
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
     throw new GirlException(ResultEnum.PRIMARY_SCHOOL);

   }else if (age > 10 && age < 16) {
     throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
   }
  }

  /**
   * 通过id查询一个女生的信息
   * @param id
   */
  public Girl findOneGirl(Integer id) {
    return girlRepository.findOne(id);
  }
}
