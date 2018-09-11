package com.wisdontech.oauth.user.repository;

import com.wisdontech.oauth.common.repository.BaseRepository;
import com.wisdontech.oauth.user.entity.User;

public interface UserRepository extends BaseRepository<User, Long> {

	User findByUsername(String username);
}
