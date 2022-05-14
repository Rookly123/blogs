package com.blogs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.Dao.UserDao;
import com.blogs.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogsApplicationTests {

	@Autowired
	private UserDao userdao;
	@Test
	void contextLoads() {
		QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
		User user = new User();
		userdao.insert(user);
		userdao.selectList(userQueryWrapper);
	}
}