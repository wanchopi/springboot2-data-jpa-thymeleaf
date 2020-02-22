package com.wanchopi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanchopi.models.Team;

/**
 * Team repository
 * 
 * @author Wanchopi
 *
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{}
