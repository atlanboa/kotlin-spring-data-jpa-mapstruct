package com.example.mapstruct

import com.example.mapstruct.entity.Person
import com.example.mapstruct.entity.PersonDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface PersonConverter {
    @Mappings(
        Mapping(target = "lastJoin", source = "lastModifiedDate")
    )
    fun personToPersonDto(person: Person) : PersonDto
}