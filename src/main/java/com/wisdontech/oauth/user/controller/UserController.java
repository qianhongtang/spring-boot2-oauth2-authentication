package com.wisdontech.oauth.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisdontech.oauth.user.entity.User;
import com.wisdontech.oauth.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "用户接口", tags = { "用户管理相关接口" })
@RestController()
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "通过username查询用户", response = User.class, notes = "通过username查询用户")
	@ApiResponse(code = 200, message = "success", response = User.class)
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public User getUser(@PathVariable String username) {
		return userService.findByUsername(username);
	}

}
