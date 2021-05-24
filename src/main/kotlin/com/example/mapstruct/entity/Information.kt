package com.example.mapstruct.entity

import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class Information (
    @Embedded
    var address: Address,
    @Embedded
    var personInfo: PersonInfo
        )