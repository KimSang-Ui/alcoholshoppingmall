package com.three.alcoholshoppingmall.project.serch;

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

}