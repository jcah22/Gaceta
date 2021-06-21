package com.jcah.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcah.models.entity.Area;
import com.jcah.models.repository.AreaRepository;

@Service
public class AreaServiceImp implements IAreaService{
	
	@Autowired
	private AreaRepository areaRepository;

	@Override
	public List<Area> listaAreas() {
		// TODO Auto-generated method stub
		return (List<Area>) areaRepository.findAll();
	}

}
