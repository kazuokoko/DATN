package com.poly.datn.rest.controler.admin;

import com.poly.datn.common.Constant;
import com.poly.datn.service.ProductCategoryService;
import com.poly.datn.service.ProductColorService;
import com.poly.datn.service.ProductDetailService;
import com.poly.datn.service.ProductService;
import com.poly.datn.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(Constant.CROSS_ORIGIN)
@RequestMapping("/api/admin/products")
public class ProductAdminRest {
    @Autowired
    ProductService productService;

    @Autowired
    ProductColorService productColorService;

    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    ProductCategoryService productCategoryService;

    @PutMapping("delete/{id}")
    public ResponseEntity<ResponseDTO<Object>> deleteProduct(@PathVariable("id") Integer id, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.delete(id, principal))
                .code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }
    @PutMapping("dontSell/{id}")
    public ResponseEntity<ResponseDTO<Object>> dontSellProduct(@PathVariable("id") Integer id, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.dontSell(id, principal))
                .code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<Object>> getList(@RequestParam("cate") Optional<Integer> cate, @RequestParam("find") Optional<String> find) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.getList(cate, find)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }
    @GetMapping("getListDelete")
    public ResponseEntity<ResponseDTO<Object>> getListDelete(@RequestParam("cate") Optional<Integer> cate, @RequestParam("find") Optional<String> find) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.getListDelete(cate, find)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO<Object>> getDetail(@PathVariable("id") Integer id) throws NullPointerException {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.getById(id)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PostMapping("newproduct")
    public ResponseEntity<ResponseDTO<Object>> newProduct(@RequestBody ProductVO productVO, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.newProduct(productVO, principal)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PostMapping("newproductdetail/{id}")
    public ResponseEntity<ResponseDTO<Object>> newProductDetail(@PathVariable("id") Optional<Integer> id, @RequestBody List<ProductDetailsVO> productDetailsVOS, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productDetailService.newProductDetail(id, productDetailsVOS, principal)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PostMapping("newproductcolor/{id}")
    public ResponseEntity<ResponseDTO<Object>> newProductColor(@PathVariable("id") Optional<Integer> id, @RequestBody List<ProductColorVO> productColorVOS, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productColorService.newProductColor(id, productColorVOS, principal)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PostMapping("newproductcategory/{id}")
    public ResponseEntity<ResponseDTO<Object>> newProductCategory(@PathVariable("id") Optional<Integer> id, @RequestBody List<ProductCategoryVO> productCategoryVOS, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productCategoryService.newProductCategory(id, productCategoryVOS, principal)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO<Object>> update(@RequestBody ProductVO productVO, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.update(productVO, principal)).code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PutMapping("selectcate")
    public ResponseEntity<ResponseDTO<Object>> selectCate(@RequestParam("pid") Integer pid, @RequestParam("cid") Integer cid, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.selectCate(pid, cid, principal))
                .code(Constant.RESPONSEDTO_CODE)
                .message(Constant.RESPONSEDTO_MESS).build());
    }
    @PutMapping("unselectcate")
    public ResponseEntity<ResponseDTO<Object>> unSelectCate(@RequestParam("pid") Integer pid, @RequestParam("cid") Integer cid, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(productService.unSelectCate(pid, cid, principal))
                .code(Constant.RESPONSEDTO_CODE)
                .message(Constant.RESPONSEDTO_MESS).build());
    }

}
