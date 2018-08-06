package com.example.product.utils;

import com.example.product.vo.ResultVO;

/**
 * Created by 黄逸晖 on 2018-08-06.
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
