package com.example.girl.handle;

import com.example.girl.domain.Result;
import com.example.girl.exception.GirlException;
import com.example.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result handle(Exception e) {
    if (e instanceof GirlException) {
      GirlException girlException = (GirlException) e;
      return ResultUtil.error(girlException.getCode(), girlException.getMessage());
    } else {
      return ResultUtil.error(-1, "未知错误");
    }
  }
}
