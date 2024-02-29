package com.genericAPI.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genericAPI.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}