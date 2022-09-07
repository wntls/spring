package net.koreate.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:context/*.xml" })
public class Mock {
	
	@Autowired
	private WebApplicationContext wc; 

	private MockMvc mvc; 

	@Before
	public void serUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
	
	//@Test
	public void listPageTest() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/sboard/listPage")
				.param("page", "1")
				.param("perPageNum", "5")
				.param("searchType", "t")
				.param("keyword", "1"))
				.andReturn().getModelAndView()
				.getModelMap();
		System.out.println("testRead : " + map);
	}
	
	//@Test
	public void register() throws Exception{
		ResultActions ra = mvc.perform(MockMvcRequestBuilders.post("/sboard/register")
				.param("title", "제목")
				.param("content", "내용")
				.param("writer", "박주신"));
		MvcResult result = ra.andReturn();
		ModelAndView mav = result.getModelAndView();
		FlashMap flash = result.getFlashMap();
		System.out.println("============================");
		System.out.println(mav);
		System.out.println("flash : "+ flash.entrySet());
		System.out.println("============================");
		System.out.println("register : " + ra);
	}
	@Test
	public void read() throws Exception {
		ModelMap model = mvc.perform(MockMvcRequestBuilders.get("/sboard/readDetail")
				.param("bno","1"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
		System.out.println("read : "+model);
	}
	
}























