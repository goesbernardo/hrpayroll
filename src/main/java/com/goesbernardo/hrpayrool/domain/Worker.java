package com.goesbernardo.hrpayrool.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Worker implements Serializable {

    private Long id;

    private String name;

    private Double dailyIncome;
}
