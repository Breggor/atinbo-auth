package com.atinbo.auth.repo;

import com.atinbo.auth.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * 会员tag Repo
 *
 * @author breggor
 */
@Repository
public interface TagRepo extends JpaRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {
}
