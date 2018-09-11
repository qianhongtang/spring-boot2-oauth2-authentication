/**
 * 
 */
package com.wisdontech.oauth.user.service;

import com.wisdontech.oauth.common.service.Service;
import com.wisdontech.oauth.user.entity.User;

/**
 * 
 * @author qianhongtang
 *
 */
public interface UserService extends Service<User, Long> {
	User findByUsername(String username);
}