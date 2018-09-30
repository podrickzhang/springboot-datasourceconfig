package com.rosam.springbootdatasourceconfig;

import com.rosam.springbootdatasourceconfig.databaseconfig.DruidDatasourceSetting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDatasourceconfigApplicationTests {

	@Autowired
	private DruidDatasourceSetting druidDatasourceSetting;


	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		System.out.println(druidDatasourceSetting.getInitialSize());//result = 5 test ok
	}

}
