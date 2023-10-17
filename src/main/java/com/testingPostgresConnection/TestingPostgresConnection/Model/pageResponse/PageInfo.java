package com.testingPostgresConnection.TestingPostgresConnection.Model.pageResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private int index;
    private int size;
    private boolean isLast;
    private boolean isFirst;
    private int maxPages;
    private long maxElements;
}
