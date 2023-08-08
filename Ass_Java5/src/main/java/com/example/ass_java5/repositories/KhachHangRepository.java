package com.example.ass_java5.repositories;

import com.example.ass_java5.entities.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {

    public KhachHang findByMaAndMatKhau(String ma, String matKhau);
}
