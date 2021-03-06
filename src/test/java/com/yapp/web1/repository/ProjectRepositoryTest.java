package com.yapp.web1.repository;

import com.yapp.web1.common.RepositoryTest;
import com.yapp.web1.domain.Orders;
import com.yapp.web1.domain.Project;
import com.yapp.web1.domain.VO.Mark;
import com.yapp.web1.domain.VO.ProjectType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertTrue;

public class ProjectRepositoryTest extends RepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    private Orders findOrders;
    private Project project;

    @Test
    public void Entity저장시_BaseEntity적용테스트(){
        // given
        findOrders = ordersRepository.getOne(1L);

        project = Project.builder()
                .type(ProjectType.WEB)
                .password("passwd")
                .name("프로젝트팀")
                .finalCheck(Mark.N)
                .releaseCheck(Mark.N)
                .createUserIdx(1L)
                .orders(findOrders)
                .build();

        LocalDateTime now = LocalDateTime.now();
        projectRepository.save(project);

        // when
        Project findProject = projectRepository.findByName("프로젝트팀");

        // then
        assertTrue(findProject.getCreateDate().isAfter(now));
        assertTrue(findProject.getModifiedDate().isAfter(now));
    }
}
