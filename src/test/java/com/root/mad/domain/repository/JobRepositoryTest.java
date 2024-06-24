package com.root.mad.domain.repository;

import com.root.mad.domain.model.Job;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Rollback
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Test
    public void createJob() {
        Job job = new Job();
        job.setTitle("test job");
        job.setDescription("test description");
        job.setCompleted(false);

        Job savedJob = jobRepository.save(job);

        assertThat(savedJob).isNotNull();
        assertThat(savedJob.getId()).isEqualTo(job.getId());
        assertThat(savedJob).isEqualTo(job);
    }
}
