package com.example.product.controller;

import com.example.product.dataObject.ProductCategory;
import com.example.product.dataObject.ProductInfo;
import com.example.product.dto.CartDTO;
import com.example.product.exception.ProductException;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import com.example.product.utils.ResultVOUtil;
import com.example.product.vo.ProductInfoVO;
import com.example.product.vo.ProductVO;
import com.example.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 黄逸晖 on 2018-08-01.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductInfoVO> list(){
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type列表
        List<Integer> categoryList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3. 查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList();
        for ( ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList();
            for (ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }


    /**
     * 获取商品列表（给订单服务调用）
     * 参数使用了@RequestBody这个注解方法上面必须使用@PostMapping
     * 如果参数里面使用@PathVariable ，@RequestParam这两个注解时可以使用@GetMapping
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public  List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return  productService.findList(productIdList);
    }

    /**
     * 扣库存
     * @param cartDTOList
     * @throws Exception
     */
    @PostMapping("/decreaseProductStock")
    public void decreaseProductStock(@RequestBody List<CartDTO> cartDTOList) throws Exception {
        productService.decreaseProductStock(cartDTOList);
    }
}
