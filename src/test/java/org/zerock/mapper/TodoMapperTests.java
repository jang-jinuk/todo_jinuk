package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.TodoVO;
import org.zerock.mapper.TodoMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
})
@Log4j
public class TodoMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private TodoMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(todo -> log.info(todo));
//		
//	}
	
	@Test
	public void testInsert() {
		TodoVO todo = new TodoVO();
		todo.setTitle("새로 작성하는 할일");
		todo.setUserid("user0");

		mapper.insert(todo);
		
		log.info(todo);
	}
	@Test
	public void testInsertSelectKey() {
		TodoVO todo = new TodoVO();
		todo.setTitle("새로 작성하는 할일");
		todo.setUserid("dummyUserd");

		mapper.insertSelectKey(todo);
		
		log.info(todo);
	}
	@Test
	public void testRead() {
		TodoVO todo = mapper.read(3L);
		log.info(todo);
	}
	@Test
	public void testDelete() {
		log.info("DELETE COUNT : " + mapper.delete(15L));
	}
	@Test
	public void testUpdate() {
		
		TodoVO todo = new TodoVO();
		todo.setTno(3L);
		todo.setTitle("수정된 할일");
		
		int count = mapper.update(todo);
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testComplete() {
		
		TodoVO todo = new TodoVO();
		todo.setTno(3L);
//		int count = mapper.complete(todo);
//		log.info("COMPLETE COUNT: " + count); 임시
	}
}
