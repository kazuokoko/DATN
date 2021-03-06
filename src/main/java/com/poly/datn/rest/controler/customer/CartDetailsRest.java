package com.poly.datn.rest.controler.customer;


import com.poly.datn.vo.CartDetailVO;
import com.poly.datn.common.Constant;
import com.poly.datn.service.CartDetailService;
import com.poly.datn.vo.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@CrossOrigin(Constant.CROSS_ORIGIN)
@RequestMapping("/api/customer/cart")
public class CartDetailsRest {

    @Autowired
    CartDetailService cartDetailService;

    @GetMapping("get")
    public ResponseEntity<ResponseDTO<Object>> getList(Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(cartDetailService.findCartByUsername(principal))
                .code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO<Object>> updateCartDetail(@RequestBody CartDetailVO cartDetailVO, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(cartDetailService.save(cartDetailVO, principal))
                .code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO<Object>> deleteCartDetail(@PathVariable Integer id, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(cartDetailService.deleteCartDetaiilById(id, principal))
                .code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }

    @PostMapping("new")
    public ResponseEntity<ResponseDTO<Object>> addToCartDetail(@RequestBody CartDetailVO cartDetailVO, Principal principal) {
        return ResponseEntity.ok(ResponseDTO.builder().object(cartDetailService.save(cartDetailVO, principal))
                .code(Constant.RESPONSEDTO_CODE).message(Constant.RESPONSEDTO_MESS).build());
    }
}
