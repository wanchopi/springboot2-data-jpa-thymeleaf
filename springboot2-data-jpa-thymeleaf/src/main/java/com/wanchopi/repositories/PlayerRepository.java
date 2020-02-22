package com.wanchopi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanchopi.models.Player;

/**
 * Player repository
 * 
 * @author Wanchopi
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{}
