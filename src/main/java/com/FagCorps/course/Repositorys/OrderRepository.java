package com.FagCorps.course.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FagCorps.course.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
