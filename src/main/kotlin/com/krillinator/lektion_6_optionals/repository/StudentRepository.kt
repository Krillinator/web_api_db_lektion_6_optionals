package com.krillinator.lektion_6_optionals.repository

import com.krillinator.lektion_6_optionals.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Long> {
}

