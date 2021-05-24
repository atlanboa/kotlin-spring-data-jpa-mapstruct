package com.example.mapstruct.entity

import com.example.mapstruct.PersonConverter
import com.example.mapstruct.repository.PersonRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Sort
import java.time.LocalDateTime

@DataJpaTest
class PersonTest @Autowired constructor(
    val personRepository: PersonRepository
) {
    @Test
    fun `Person Save Test` () {
        val jaden = Person(name = "Jaden")

        personRepository.save(jaden)

        println("${jaden.id} :: ${jaden.name} :: ${jaden.creationDate} :: ${jaden.lastModifiedDate}")
    }


    @Test
    fun `Person Save And Convert to Dto Test` () {
        val jaden = Person(name = "Jaden")

        personRepository.save(jaden)

        println("${jaden.id} :: ${jaden.name} :: ${jaden.creationDate} :: ${jaden.lastModifiedDate}")

        val personConverter = Mappers.getMapper(PersonConverter::class.java)
        val jadenDto = personConverter.personToPersonDto(jaden)

        println(jadenDto)
    }

    @Test
    fun `Person Save With Custom CreationDate Test` () {

        val time1 = LocalDateTime.now()
        val time2 = time1.plusDays(1)
        val time3 = time1.plusDays(2)
        val time4 = time1.plusDays(3)

        val jaden = Person(name = "Jaden").apply {
            this.creationDate = time1
        }

        val jason = Person(name = "Jason").apply {
            this.creationDate = time2
        }

        val jacob = Person(name = "Jacob").apply {
            this.creationDate = time3
        }

        val jesus = Person(name = "Jesus").apply {
            this.creationDate = time4
        }

        val personList = listOf(jaden, jason, jacob, jesus)

        personRepository.saveAll(personList)


        val sort: Sort = Sort.by(Sort.Direction.ASC, "creationDate")
        val findAll = personRepository.findAll(sort)

        findAll.forEach {
            println(it.creationDate)
        }

    }

}