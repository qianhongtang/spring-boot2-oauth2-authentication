/**
 * 
 */
package com.wisdontech.oauth.user.service.impl;

import org.springframework.stereotype.Service;

import com.wisdontech.oauth.common.repository.BaseRepository;
import com.wisdontech.oauth.common.service.AbstractService;
import com.wisdontech.oauth.user.entity.UserRole;
import com.wisdontech.oauth.user.service.UserRoleService;

/**
 * 
 * @author qianhongtang
 *
 */
@Service
public class UserRoleServiceImpl extends AbstractService<UserRole, Long, BaseRepository<UserRole, Long>>
		implements UserRoleService {

}
