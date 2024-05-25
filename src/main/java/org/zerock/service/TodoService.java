package org.zerock.service;

import java.util.List;

import org.zerock.domain.TodoVO;

public interface TodoService {
	public void register(TodoVO todo);
	public TodoVO get(Long tno);
	public boolean modify(TodoVO todo);
	public boolean remove(Long tno);
	public List<TodoVO> getList(String userid);
	public boolean complete(Long tno);
}
