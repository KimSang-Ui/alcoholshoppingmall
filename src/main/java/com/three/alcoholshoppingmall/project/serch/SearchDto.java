<<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/SearchDto.java
package com.three.alcoholshoppingmall.project.main;
========
package com.three.alcoholshoppingmall.project.serch;
>>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/serch/SearchDto.java

import com.three.alcoholshoppingmall.project.entity.Alcohol;
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

<<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/SearchDto.java

========
    //email 우쨰 쓸까? 유저에서 가져와야겠네
>>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/serch/SearchDto.java
}