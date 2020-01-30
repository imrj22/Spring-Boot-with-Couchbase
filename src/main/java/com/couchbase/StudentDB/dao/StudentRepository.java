package com.couchbase.StudentDB.dao;

import com.couchbase.StudentDB.model.Student;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "student", viewName = "all")

public interface StudentRepository extends CouchbaseRepository <Student, Integer> {

}
