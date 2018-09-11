/**
 * 
 */
package com.wisdontech.oauth.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wisdontech.oauth.common.repository.BaseRepository;
import com.wisdontech.oauth.common.service.AbstractService;
import com.wisdontech.oauth.user.entity.Role;
import com.wisdontech.oauth.user.repository.RoleRepository;
import com.wisdontech.oauth.user.service.RoleService;

/**
 * 
 * @author qianhongtang
 *
 */
@Service
public class RoleServiceImpl extends AbstractService<Role, Long, BaseRepository<Role, Long>> implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Cacheable(value = "redisCache", key = "'find-role-by-userid-' + #userId")
	public List<Role> findByUserId(Long userId) {
		return roleRepository.findByUserId(userId);
	}

}
