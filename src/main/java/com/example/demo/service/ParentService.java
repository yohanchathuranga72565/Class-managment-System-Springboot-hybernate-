package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Parent;

public interface ParentService {

	List<Parent> getAllParents();
	void saveParent(Parent parent);
	Parent getParentById(long id);
	void deleteParentById(long id);
}
