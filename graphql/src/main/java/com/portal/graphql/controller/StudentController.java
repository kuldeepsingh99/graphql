package com.portal.graphql.controller;

import com.portal.graphql.dto.AddressDTO;
import com.portal.graphql.dto.StudentDTO;
import com.portal.graphql.entity.Address;
import com.portal.graphql.entity.PostComments;
import com.portal.graphql.entity.Posts;
import com.portal.graphql.entity.Student;
import com.portal.graphql.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @QueryMapping
    public Student getStudentById(@Argument String studentId){
        return studentService.findById(Long.valueOf(studentId));
    }

    @MutationMapping
    public Student createNewStudent(@Argument StudentDTO studentDTO){
        return studentService.createStudent(studentDTO.getName(),studentDTO.getAddress());
    }

    @QueryMapping
    public List<Address> getAllAddress(){
        return studentService.findAllAddress();
    }

    @QueryMapping
    public Address getAddressById(@Argument String addressId){
        return studentService.findAddressById(Long.valueOf(addressId));
    }

    @MutationMapping
    public Address createNewAddress(@Argument AddressDTO addressDTO){
        return studentService.createAddress(addressDTO.getName(), addressDTO.getCity(), addressDTO.getCountry());
    }

    @SchemaMapping(typeName = "Student", field = "address")
    public Address address(Student student) {
        return studentService.getAddressByAddress(student.getAddress());
    }
}
