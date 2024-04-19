package com.three.alcoholshoppingmall.project.alcohol;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlcoholDto {


    private Long id;

    private String alcohol_name;

    private String maincategory;

    private String subcategory;

}