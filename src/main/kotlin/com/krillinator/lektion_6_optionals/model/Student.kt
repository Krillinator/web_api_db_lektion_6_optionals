package com.krillinator.lektion_6_optionals.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Student(
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val hasGraduated: Boolean = false,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
)

