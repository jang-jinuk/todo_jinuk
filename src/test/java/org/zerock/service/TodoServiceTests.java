package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.TodoVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
})
@Log4j
public class TodoServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private TodoService service; 
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	@Test
	public void testRegister() {
		TodoVO todo = new TodoVO();
		todo.setTitle("새로 작성하는 할일");
		todo.setUserid("user0");
		
		service.register(todo);
		
		log.info("생성된 게시물의 번호 : " + todo.getTno());
	}
	@Test
	public void testRead() {
		TodoVO todo = service.get(2L);
		log.info(todo);
	}
	@Test
	public void testModify() {
		
		TodoVO todo = new TodoVO();
		todo.setTno(4L);
		todo.setTitle("수정된 할일");
		service.modify(todo);
		
		log.info("modify....");
	}
	@Test
	public void testRemove() {
		
		service.remove(4L);
		log.info("remove....");
	}
	@Test
	public void testGetlist() {
		service.getList("user0");
		log.info("getlist....");
	}
	@Test
	public void testComplete() {
		
		service.complete(5L);
		log.info("complete....");
	}
}
