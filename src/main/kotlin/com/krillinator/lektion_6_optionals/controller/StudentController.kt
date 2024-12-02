package com.krillinator.lektion_6_optionals.controller

import com.krillinator.lektion_6_optionals.model.Student
import com.krillinator.lektion_6_optionals.repository.StudentRepository
import com.krillinator.lektion_6_optionals.response.StudentResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/student")
class StudentController(
    @Autowired val studentRepository: StudentRepository
) {

    // localhost:8080/student
    @GetMapping
    fun getAllStudents(): MutableList<Student> {

        return studentRepository.findAll()
    }

    // localhost:8080/student/find
    // Never return an optional
    @GetMapping("/find")
    fun getStudentById(@RequestParam("id") id: Long): ResponseEntity<StudentResponse> {

        val optionalStudent: Optional<Student> = studentRepository.findById(id)

        // Is optional null?
        if(optionalStudent.isPresent) {
            val foundStudent: Student = optionalStudent.get()

            return ResponseEntity.ok().body(
                StudentResponse(foundStudent, "Student FOUND")
            )
        }

        return ResponseEntity.status(404).body(
            StudentResponse(null, "Student FOUND")
        )
    }













    @PostMapping
    fun postStudent(@RequestBody student: Student): Student {

        studentRepository.save(student)

        return student
    }

}