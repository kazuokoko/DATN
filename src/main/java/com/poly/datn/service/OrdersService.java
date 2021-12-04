package com.poly.datn.service;

import com.poly.datn.entity.Orders;
import com.poly.datn.vo.CustomerVO;
import com.poly.datn.vo.OrderDetailsVO;
import com.poly.datn.vo.OrdersVO;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<OrdersVO> getByUsername(Principal principal);

    List<OrdersVO> getAll(Principal principal);

    OrdersVO getByIdAndUserName(Integer id, Principal principal) throws SecurityException;
//, OrderDetailsVO orderDetailsVO, CustomerVO customerVO
    OrdersVO newOrder(OrdersVO ordersVO, Principal principal);

    OrdersVO getByIdAndUserNameAdmin(Integer id, Principal principal);

    boolean cancerOrder(Integer id, Principal principal);

    OrdersVO newOrderAdmin(OrdersVO ordersVO, Principal principal);

    OrdersVO updateOrderAdmin(Optional<Integer> id, Optional<String> status, Principal principal);

    List<OrdersVO> getList(Principal principal, Optional<Integer> id, Optional<String> email, Optional<String> name, Optional<String> phone);
}
