package com.couchbase.StudentDB.model;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class College {
    @Id
    private Integer collegeId;
    @Field
    private String colName;
    @Field
    private String colAdd;
}
