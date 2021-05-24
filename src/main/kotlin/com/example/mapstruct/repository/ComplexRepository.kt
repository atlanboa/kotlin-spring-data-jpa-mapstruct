package com.example.mapstruct.repository

import com.example.mapstruct.entity.ComplexEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComplexRepository : JpaRepository<ComplexEntity, Long> {
}