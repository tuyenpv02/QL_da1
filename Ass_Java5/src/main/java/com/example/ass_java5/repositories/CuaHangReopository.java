package com.example.ass_java5.repositories;

import com.example.ass_java5.entities.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CuaHangReopository extends JpaRepository<CuaHang, UUID> {
}
