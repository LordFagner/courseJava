package com.FagCorps.course.Repositorys;
import org.springframework.data.jpa.repository.JpaRepository;

import com.FagCorps.course.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
