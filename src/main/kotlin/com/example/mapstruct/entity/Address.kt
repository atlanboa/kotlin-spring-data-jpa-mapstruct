package com.example.mapstruct.entity

import javax.persistence.Embeddable

@Embeddable
class Address (
    var city: String,
    var street: String
        )