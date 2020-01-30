package com.couchbase.StudentDB.service;

import com.couchbase.StudentDB.dao.CollegeRepository;
import com.couchbase.StudentDB.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;


    public CollegeRepository getCollegeRepository() {
        return collegeRepository;
    }

    public void setCollegeRepository(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }


    public Iterable<College> findAll()
    {
        Iterable<College> colleges = collegeRepository.findAll();
        return colleges;
    }

    public Optional<College> findById(Integer collegeId) {

        return collegeRepository.findById(collegeId);
    }

    public College save(College college) {

        return collegeRepository.save(college);
    }

    public void deleteById(Integer collegeId) {
        collegeRepository.deleteById(collegeId);

    }

}
