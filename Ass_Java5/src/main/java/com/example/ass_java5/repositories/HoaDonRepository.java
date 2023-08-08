package com.example.ass_java5.repositories;

import com.example.ass_java5.entities.HoaDon;
import com.example.ass_java5.entities.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {

    public HoaDon findHoaDonByMa(String ma);

    public List<HoaDon> findByTinhTrang(int tinhTrang);


    public HoaDon findByMaAndAndKhachHang(String ma, KhachHang khachHang);

    public List<HoaDon> findByTinhTrangAndKhachHang(int ti, KhachHang khachHang);

}
