package com.example.mapstruct.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person (
    @Id @GeneratedValue
    var id: Long? = null,
    val name: String,
    ) : BaseEntity()