package com.example.mapstruct.entity

import javax.persistence.Embeddable

@Embeddable
class PersonInfo (
    var name: String,
    var age: Int
        )