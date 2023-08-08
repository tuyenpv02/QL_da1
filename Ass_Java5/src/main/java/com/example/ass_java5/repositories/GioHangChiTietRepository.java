package com.example.ass_java5.repositories;

import com.example.ass_java5.entities.GHCT;
import com.example.ass_java5.entities.GioHangChiTietID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GHCT, GioHangChiTietID> {


}
