package com.wisdontech.oauth.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisdontech.oauth.user.entity.Role;
import com.wisdontech.oauth.user.entity.User;
import com.wisdontech.oauth.user.service.RoleService;
import com.wisdontech.oauth.user.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// 获取数据库用户信息
		User user = userService.findByUsername(userName);
		// 获取数据库角色信息
		List<Role> roleList = roleService.findByUserId(user.getId());
		// 将信息转换为UserDetails对象
		return changeToUser(user, roleList);
	}

	private UserDetails changeToUser(User user, List<Role> roleList) {
		// 权限列表
		List<GrantedAuthority> authorityList = new ArrayList<>();
		// 赋予查询到的角色
		for (Role role : roleList) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
			authorityList.add(authority);
		}
		// 创建UserDetails对象，设置用户名、密码和权限
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorityList);
	}

}
