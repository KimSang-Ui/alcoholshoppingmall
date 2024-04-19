package com.three.alcoholshoppingmall.project.search;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.user.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private Alcohol alcohol;

    private String searchcontents;

    private User user;

    //email 우쨰 쓸까? 유저에서 가져와야겠네
}