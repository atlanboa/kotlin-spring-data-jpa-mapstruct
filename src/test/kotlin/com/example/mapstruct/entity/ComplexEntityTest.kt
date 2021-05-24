package com.example.mapstruct.entity

import com.example.mapstruct.ComplexConverter
import com.example.mapstruct.repository.ComplexRepository
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ComplexEntityTest @Autowired constructor(
    val complexRepository: ComplexRepository
) {
    @Test
    fun `complexEntityTest`() {
        val complex = ComplexEntity(
            info = Information(
                address = Address("city", "street"),
                personInfo = PersonInfo("jaden", 10)
            )
        )
        complexRepository.save(complex)

        val findComplex = complexRepository.findById(complex.id!!).get()

        val converter = Mappers.getMapper(ComplexConverter::class.java)
        val entityToDto = converter.entityToDto(findComplex)

        println(
            "${entityToDto.info.address.city} ${entityToDto.info.personInfo.name}"
        )
    }
}