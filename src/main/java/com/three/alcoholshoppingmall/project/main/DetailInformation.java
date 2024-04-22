<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/DetailInformation.java
package com.three.alcoholshoppingmall.project.main;
=======
package com.three.alcoholshoppingmall.project.alcohol;
>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/DetailInformation.java


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/DetailInformation.java
@Schema(description = "메인 페이지용 정보저장 클래스")
=======
@Schema(description = "상세 페이지용 정보저장 클래스")
>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/DetailInformation.java
public class DetailInformation {


    @Schema(title = "주류 ID", description = "주류의 KEY값 입니다.")
    private Long id;

    @Schema(title = "주류 이름", description = "주류 이름을 넣어주시면 됩니다.")
    private String name;

    @Schema(title = "주류의 평균 평점", description = "주류의 평균 평점 입니다.")
    private double ratingaverage;

    @Schema(title = "주류의 가격", description = "주류의 가격 입니다.")
    private int price;

    @Schema(title = "주류 대분류", description = "주류의 대분류를 넣어주시면 됩니다.")
    private String maincategory;

    @Schema(title = "주류 소분류", description = "주류의 소분류를 넣어주시면 됩니다.")
    private String subcategory;

    @Schema(title = "주류 도수", description = "주류의 도수을 넣어주시면 됩니다.")
    private String content;

    @Schema(title = "주류 향", description = "주류 향을 넣어주시면 됩니다.")
    private String aroma;

    @Schema(title = "주류 맛", description = "주류 맛을 넣어주시면 됩니다.")
    private String taste;

    @Schema(title = "주류 여운", description = "주류의 여운을 넣어주시면 됩니다.")
    private String finish;

    @Schema(title = "주류 국가", description = "주류의 국가를 넣어주시면 됩니다.")
    private String nation;

    @Schema(title = "주류 사진", description = "주류의 사진")
    private String picture;

    @Schema(title = "리뷰 갯수", description = "선택한 술의 리뷰 갯수 입니다.")
    private int reviewcacount;












}