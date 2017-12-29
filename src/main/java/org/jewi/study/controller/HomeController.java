package org.jewi.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.jewi.study.entity.User;
import org.jewi.study.enums.ResMsg;
import org.jewi.study.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class HomeController {
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		 //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
		logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(StringUtils.isEmpty(username)) {
			return ResMsg.USER_NAME_BLANK.toJSONString();
		}
		if(StringUtils.isEmpty(password)) {
			return ResMsg.USER_PASSWORD_BLANK.toJSONString();
		}
		
		boolean result = userService.login(username, password);
		if(!result) {
			return ResMsg.FAIL.toJSONString();
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		request.getSession().setAttribute("currentUser", user);
		
		return ResMsg.SUCCESS.toJSONString();
	}
}
