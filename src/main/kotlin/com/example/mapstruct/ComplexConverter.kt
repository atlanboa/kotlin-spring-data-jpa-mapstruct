package com.example.mapstruct

import com.example.mapstruct.entity.ComplexDto
import com.example.mapstruct.entity.ComplexEntity
import org.mapstruct.Mapper

@Mapper
interface ComplexConverter {
    fun entityToDto(complex: ComplexEntity) : ComplexDto
}