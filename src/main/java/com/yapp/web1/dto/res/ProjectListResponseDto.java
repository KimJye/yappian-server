package com.yapp.web1.dto.res;

import com.yapp.web1.domain.VO.Mark;
import com.yapp.web1.domain.VO.ProjectType;
import lombok.Builder;
import lombok.Getter;

/**
 * 프로젝트 리스트 Dto
 *
 * @author JiHye Kim
 * @author Dakyung Ko
 */
@Getter
public class ProjectListResponseDto {

    private Long projectIdx; // 프로젝트 idx
    private ProjectType projectType; //프로젝트 타입
    private String projectName; // 프로젝트 이름
    private Mark finalCheck; // 프로젝트 완료 여부
    private Long createUserIdx; // 생성한 유저 Idx
    private int orderNumber; // 기수
    private Mark favorite; // 북마크
    private Mark joined; // 조인여부

    @Builder
    public ProjectListResponseDto(Long projectIdx, ProjectType projectType, String projectName, Mark finalCheck, Long createUserIdx,
                                  int orderNumber, Mark favorite, Mark joined){
        this.projectIdx = projectIdx;
        this.projectType = projectType;
        this.projectName = projectName;
        this.finalCheck = finalCheck;
        this.createUserIdx = createUserIdx;
        this.orderNumber = orderNumber;
        this.favorite = favorite;
        this.joined = joined;
    }

}
