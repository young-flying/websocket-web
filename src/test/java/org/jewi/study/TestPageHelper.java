package org.jewi.study;
import java.util.List;

import org.jewi.study.entity.User;
import org.jewi.study.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPageHelper {
	@Autowired
	private UserService userService;
	
    @Test
    public void findOne() {
    	List<User> userList = userService.queryList(0, 10);
    	userList.forEach((user)->{
    		System.out.println(user.toString());
    	});
    	
    }
}