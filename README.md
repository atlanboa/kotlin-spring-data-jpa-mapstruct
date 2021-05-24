# kotlin-spring-data-jpa-mapstruct

# MapStruct Guide

# 왜 쓰는가?

- type safe 하게 bean mapping 을 도와주는 어노테이션 프로세서
- JPA 기반 어플리케이션 개발에서 DTO 변환 작업은 반복적인 작업이 대부분
- ModelMapper 는 리플렉션 기반으로 동작, 퍼포먼스 이슈가 많음

# Mapstruct plugin installation

intellij Mapstruct 플러그인 설치


# Gradle Configuration

build.gradle (gradle version 4.6 이상)

```groovy
plugins {
    kotlin("jvm") version "1.5.0"
    kotlin("kapt") version "1.4.0"
}

dependencies {
		//Mapstruct
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")
}
```

# Sample Code

```kotlin
// Car

class Car (
    val brand: String,
    val numberOfSeats: Int,
    val carType: CarType
    )

// CarDto

class CarDto (
    val brand: String,
    val seatCount: Int,
    val carType: String
    )

// CarType
enum class CarType {
    SUV, RACING, TRUCK
}

// CarMapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface CarMapper {
    @Mapping(source = "numberOfSeats", target = "seatCount")
    fun carToCarDto(car : Car) : CarDto
}

//Usage
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers

class MappingTest {
    @Test
    fun mappingTest() {
        val car = Car("kia", 10, CarType.TRUCK)
        val converter = Mappers.getMapper(CarMapper::class.java)
        var carDto = converter.carToCarDto(car)

        println("${carDto.brand} ${carDto.carType} ${carDto.seatCount}")
    }
}
```

- target 클래스에 해당 필드가 없으면 무시됌.
- 복합 클래스도 알아서 만들어줌.. 딱히 신경쓸 필요 없을듯.
