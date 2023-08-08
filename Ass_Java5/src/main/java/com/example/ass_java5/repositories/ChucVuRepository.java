package com.example.ass_java5.repositories;

import com.example.ass_java5.entities.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
}
