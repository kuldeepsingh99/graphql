package com.portal.graphql.service;

import com.portal.graphql.entity.Address;
import com.portal.graphql.entity.Student;
import com.portal.graphql.repository.AddressRepository;
import com.portal.graphql.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final AddressRepository addressRepository;

    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new RuntimeException("Student not Found"));
    }

    public Student createStudent(String name, String address){
        Student student = new Student(name, address);
        return studentRepository.save(student);
    }

    public List<Address> findAllAddress(){
        return addressRepository.findAll();
    }

    public Address findAddressById(Long addressId){
        return addressRepository.findById(addressId)
                .orElseThrow(()-> new RuntimeException("Address not Found"));
    }

    public Address createAddress(String name, String city, String country){
        Address address = new Address(name, city, country);
        return addressRepository.save(address);
    }

    public Address getAddressByAddress(String address) {
        return addressRepository.findByName(address).orElse(null);
    }
}
