package com.example.mapstruct.entity

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ComplexEntity (
    @Id @GeneratedValue
    var id : Long? = null,
    @Embedded
    val info: Information
        )