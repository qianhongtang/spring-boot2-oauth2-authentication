package com.wisdontech.oauth.user.service;

import java.util.List;

import com.wisdontech.oauth.common.service.Service;
import com.wisdontech.oauth.user.entity.Role;

/**
 * 
 * 
 * @author qianhongtang
 *
 */
public interface RoleService extends Service<Role, Long> {

	List<Role> findByUserId(Long userId);

}
