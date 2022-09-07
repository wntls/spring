package net.koreate.lombok;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LombokTest {
	
	@Test
	public void lombokTest() {
		System.out.println("Test junit");
		UserVO user1 = new UserVO("id001","pw001","박주신");
		user1.setUid("id001");
		user1.setUpw("pw001");
		UserVO user2 = new UserVO("id001","pw001","김주신");
		System.out.println(user1.equals(user2));
		System.out.println(user1);
		
		List<String> friendList = new ArrayList<>();
		friendList.add("박주신");
		friendList.add("최기근");
		UserVO user3 = UserVO.builder()
				.uid("id001")
				.upw("pw001")
				.uno(1)
				.uname("박주신")
				//.friendList(friendList)
				.list("최기근").list("박주신").list("하옥형")
				.build(); 
		System.out.println(user3);
	}
	
}
