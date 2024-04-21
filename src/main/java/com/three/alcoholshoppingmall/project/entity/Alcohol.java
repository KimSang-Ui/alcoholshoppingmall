package com.three.alcoholshoppingmall.project.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "alcohol")
@Schema(description = "alcohol 테이블에 대한 내용입니다.")
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "주류 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Schema(title = "주류 이름", description = "주류 이름을 넣어주시면 됩니다.")
    private String name;

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

    @Schema(title = "주류 사진", description = " 주류의 사진을 넣어주시면 됩니다.")
    private String picture;


}