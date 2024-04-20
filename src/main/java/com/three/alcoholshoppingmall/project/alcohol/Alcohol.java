package com.three.alcoholshoppingmall.project.alcohol;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alcohol")
@Schema(description = "alcohol 테이블에 대한 내용입니다.")
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "술 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;
    // 필요 기능
    // 1. 술이름을 검색하였을때 해당술의 정보가 나와야한다
    // 2. 술이름을 전체 완성 안해도 나와야한다 (콘테이닝쓰던가 라이크 쓰던가)
    // 3. 검색한 내용이 최근 검색에 기록이 되어야 한다
    @Schema(title = "술 이름", description = "술 이름을 넣어주시면 됩니다.")
    private String name;

    @Schema(title = "술 대분류", description = "술의 대분류를 넣어주시면 됩니다.")
    private String maincategory;
    @Schema(title = "술 소분류", description = "술의 소분류를 넣어주시면 됩니다.")
    private String subcategory;
    @Schema(title = "술 도수", description = "술의 도수를 넣어주시면 됩니다.")
    private String content;
    @Schema(title = "술 맛", description = "술 맛을 넣어주시면 됩니다.")
    private String taste;
    @Schema(title = "술 향", description = "술 향을 넣어주시면 됩니다.")
    private String aroma;
    @Schema(title = "술 여운", description = "술의 여운을 넣어주시면 됩니다.")
    private String finish;
    @Schema(title = "술 국가", description = "술의 국가를 넣어주시면 됩니다.")
    private String nation;
    @Schema(title = "술 그림", description = " 술의 그림을 넣어주시면 됩니다.")
    private String picture;

}