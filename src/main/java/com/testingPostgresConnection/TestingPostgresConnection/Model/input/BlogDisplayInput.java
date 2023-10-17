package com.testingPostgresConnection.TestingPostgresConnection.Model.input;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDisplayInput {
    private Integer index;
    private Integer size;
    private String sortType;
    private String searchValue;
}
