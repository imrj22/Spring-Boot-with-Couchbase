package com.couchbase.StudentDB.dao;

import com.couchbase.StudentDB.model.College;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "college", viewName = "all")

public interface CollegeRepository extends CouchbaseRepository<College, Integer> {

}
