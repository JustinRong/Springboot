package com.example.girl.controller;

import com.example.girl.aspect.HttpAspect;
import com.example.girl.domain.Girl;
import com.example.girl.domain.Result;
import com.example.girl.repository.GirlRepository;
import com.example.girl.service.GirlService;
import com.example.girl.utils.ResultUtil;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {
  private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


  @Autowired
  private GirlRepository girlRepository;

  @Autowired
  private GirlService girlService;

  /**
   * 查询所有女生列表
   * @return
   */
  @GetMapping(value = "/girls")
  public List<Girl> getGirls() {
    logger.info("getGirls");
    return girlRepository.findAll();
  }

  /**
   * 添加一个女生
   * @return
   */
  @PostMapping(value = "girls")
  public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
    if (bindingResult.hasFieldErrors()) {
      return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
    }

    girl.setCupSize(girl.getCupSize());
    girl.setAge(girl.getAge());

    return ResultUtil.success(girlRepository.save(girl));
  }

  /**
   * 查找一个女生
   * @param id
   */
  @GetMapping(value = "/girls/{id}")
  public Girl girlFindOne(@PathVariable("id") Integer id) {
    return girlRepository.findOne(id);
  }

  /**
   * 更新一个女生
   * @param id
   * @param cupSize
   * @param age
   * @return
   */
  @PutMapping(value = "/girls/{id}")
  public Girl updateGirl(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age) {
    Girl girl = new Girl();
    girl.setCupSize(cupSize);
    girl.setId(id);
    girl.setAge(age);
    return girlRepository.save(girl);
  }

  /**
   * 删除一个女生
   * @param id
   */
  @DeleteMapping(value = "/girls/{id}")
  public void deleteGirl(@PathVariable("id") Integer id) {
    girlRepository.delete(id);
  }

  /**
   * 通过年龄查询女生
   * @param age
   * @return
   */
  @GetMapping(value = "/girls/age/{age}")
  public List<Girl> findGirlList(@PathVariable("age") Integer age) {
    return girlRepository.findByAge(age);
  }

  /**
   * 插入两个女生
   */
  @PostMapping(value = "/girls/two")
  public void insertTwoGirls() {
    girlService.insertTwoGirls();
  }

  /**
   * 根据id获取年龄
   */
  @GetMapping(value = "/girls/getAge/{id}")
  public void getAge(@PathVariable("id") Integer id) throws Exception {
    girlService.getAge(id);
  }
}
