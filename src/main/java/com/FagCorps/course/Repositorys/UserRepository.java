package com.FagCorps.course.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FagCorps.course.entites.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{}