package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	MenuRepository mr;

	public List<Menu> getAllMenu() {
		return mr.findAll();
	}

	public List<Menu> getSelectMenu(Type type) {
		// TODO Auto-generated method stub
		return mr.findByType(type);
	}

	public List<Menu> getSelectTwoMenu(Type type, Taste taste) {
		// TODO Auto-generated method stub
		return mr.findByTypeAndTaste(type,taste);
	}

	public Optional<Menu> getSelectSingleMenu(Long id) {
		// TODO Auto-generated method stub
		return mr.findById(id);
	}

	public Menu insertMenu(Menu m) {
		// TODO Auto-generated method stub
		return mr.save(m);
	}

	public Menu updateMenu(Menu m) {
		// TODO Auto-generated method stub
		Menu target = mr.findById(m.getId()).get();
		return mr.save(m);
	}
	
	public void deleteMenu(Long id) {
		mr.deleteById(id);
	}
}
