package com.example.mapstruct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class MapstructApplication

fun main(args: Array<String>) {
	runApplication<MapstructApplication>(*args)
}
