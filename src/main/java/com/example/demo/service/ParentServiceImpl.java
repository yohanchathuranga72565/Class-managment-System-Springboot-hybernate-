package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Parent;

import com.example.demo.repository.ParentRepository;


@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepository;
	
	@Override
	public List<Parent> getAllParents() {
		return parentRepository.findAll();
	}

	@Override
	public void saveParent(Parent parent) {
		this.parentRepository.save(parent);
		
	}

	@Override
	public Parent getParentById(long id) {
		Optional<Parent> optional = parentRepository.findById(id);
		Parent parent = null;
		if(optional.isPresent()) {
			parent = optional.get();
		}
		else {
			throw new RuntimeException("Student not found for id :: " + id);
		}
		return parent;
	}

	@Override
	public void deleteParentById(long id) {
		this.parentRepository.deleteById(id);
		
	}

}
