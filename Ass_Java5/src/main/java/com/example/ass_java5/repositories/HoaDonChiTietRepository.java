package com.example.ass_java5.repositories;

import com.example.ass_java5.entities.HDCT;
import com.example.ass_java5.entities.HoaDonChiTietID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HDCT, HoaDonChiTietID> {


}
