package com.couchbase.StudentDB.controller;

import com.couchbase.StudentDB.model.College;
import com.couchbase.StudentDB.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/college")

public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    public CollegeService getCollegeService() {
        return collegeService;
    }

    public void setCollegeService(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping("/get")
    public Iterable<College> getAllColleges() {

        return collegeService.findAll();
    }

    @PostMapping("/post")
    College createCollege(@RequestBody College newCollege) {

        return collegeService.save(newCollege);
    }

    @GetMapping("/get/{id}")
    College getCollegeById(@PathVariable("id") Integer collegeId) {

        return collegeService.findById(collegeId).get();
    }

    @PutMapping("/put/{id}")
    College updateCollege(@RequestBody College newCollege, @PathVariable("id") Integer collegeId) {
        return collegeService.findById(collegeId).map(college -> {
            college.setCollegeId(newCollege.getCollegeId());
            college.setColName(newCollege.getColName());
            college.setColAdd(newCollege.getColAdd());
            return collegeService.save(college);
        }).orElseGet(() -> {
            newCollege.setCollegeId(collegeId);
            return collegeService.save(newCollege);
        });
    }

    @DeleteMapping("/delete/{id}")
    void deleteCollege(@PathVariable("id") Integer collegeId) {

        collegeService.deleteById(collegeId);
    }


}
