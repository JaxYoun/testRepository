package com.service.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.BaseService;

@Service(value="demoService")
public class DemoServiceImpl extends BaseService implements IDemoService {

	@Override
	public List<Object> getDemoById(int id){
		List<Object> demoList = this.mybatisDao.getObjectList("demo.getDemoById", id);
		return demoList;
	}
}
