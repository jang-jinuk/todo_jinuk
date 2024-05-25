package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.TodoVO;
import org.zerock.mapper.TodoMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

	private TodoMapper mapper;
	
	@Override
	public void register(TodoVO todo) {
		log.info("register......" + todo);
		mapper.insertSelectKey(todo);
	}

	@Override
	public TodoVO get(Long tno) {
		log.info("get......." + tno);
		return mapper.read(tno);
	}

	@Override
	public boolean modify(TodoVO todo) {
		log.info("modify...." + todo);
		return mapper.update(todo) == 1;
	}

	@Override
	public boolean remove(Long tno) {
		log.info("remove...." + tno);
		return mapper.delete(tno) == 1;
	}

	@Override
	public List<TodoVO> getList(String userid) {
		log.info("getList....");
		return mapper.getList(userid);
	}
	
	@Override
	public boolean complete(Long tno) {
		log.info("complete...." + tno);
		return mapper.complete(tno) == 1;
	}

}
