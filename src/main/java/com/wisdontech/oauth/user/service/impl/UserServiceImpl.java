/**
 * 
 */
package com.wisdontech.oauth.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wisdontech.oauth.common.repository.BaseRepository;
import com.wisdontech.oauth.common.service.AbstractService;
import com.wisdontech.oauth.user.entity.User;
import com.wisdontech.oauth.user.repository.UserRepository;
import com.wisdontech.oauth.user.service.UserService;

/**
 * 
 * @author qianhongtang
 *
 */
@Service
public class UserServiceImpl extends AbstractService<User, Long, BaseRepository<User, Long>> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Cacheable(value = "redisCache", key = "'find-user-by-username-' + #username")
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
