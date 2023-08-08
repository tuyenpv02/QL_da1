package com.example.ass_java5.repositories;

import com.example.ass_java5.entities.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {

    @Query("SELECT ct from ChiTietSP ct where " +
            " ct.sanPham.ten like %?1% ")
    Page<ChiTietSP> search(String ten, Pageable pageable);
}
