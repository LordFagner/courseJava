package com.FagCorps.course.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FagCorps.course.entites.Order;
import com.FagCorps.course.entites.OrderItem;
import com.FagCorps.course.entites.Pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
