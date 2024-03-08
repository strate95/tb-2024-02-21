package com.ll.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class WSlist {
    @Getter
    private int num;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private String author;
}