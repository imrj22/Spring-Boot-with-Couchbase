package com.couchbase.StudentDB.model;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Student {
    @Id
    private int stId;
    @Field
    private String stName;
    @Field
    private String collegeId;
}
