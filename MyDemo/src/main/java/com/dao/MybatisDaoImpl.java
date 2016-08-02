/**
 * 
 */
package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.common.exception.DaoException;
import com.common.vo.ListVo;

/**
 * @author Youn
 *
 */
@Repository(value="mybatisDao")
public class MybatisDaoImpl extends BaseDao implements IMybatisDao {
	@Override
	public Object getObjectByID(String statement, int id) {
		Object object;
		try {
			object = sqlSession.selectOne(statement, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return object;
	}
	
	@Override
	public Object getObjectByMap(String statement, Map<String,Object> paramMap) {
		Object object;
		try {
			object = sqlSession.selectOne(statement, paramMap);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return object;
	}
	
	@Override
	public Object getUniqueObject(String statement, Object object) {
		Object obj;
		try {
			obj = sqlSession.selectOne(statement, object);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return obj;
	}


	@Override
	public List<Object> getObjectList(String statement, Object param) {
		List<Object> objectList = new ArrayList<Object>();
		try {
			objectList = sqlSession.selectList(statement, param);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return objectList;
	}
	
	@Override
	public List<Object> getObjectList(Map<String,Object> parameter) {
		List<Object> objectList = new ArrayList<Object>();
		try {
			objectList = sqlSession.selectList("common.select", parameter);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return objectList;
	}

	@Override
	public ListVo<Object> getObjectPage(String statement, Map<String,Object> parameter, RowBounds rowBounds) {
		ListVo<Object> listVo = new ListVo<Object>();
		try {
			if(rowBounds==null){
				List<Object> listObect = sqlSession.selectList(statement, parameter);
				listVo.setList(listObect);
				listVo.setTotalSize(-1);
			}else{
				List<Object> listObect = sqlSession.selectList(statement, parameter, rowBounds);
				listVo.setList(listObect);
				listVo.setTotalSize((Integer)parameter.get("pageCount"));
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} 
		return listVo;
	}
	
	@Override
	public ListVo<Object> getObjectPage(Map<String,Object> parameter, RowBounds rowBounds) {
		ListVo<Object> listVo = new ListVo<Object>();
		try {
			if(rowBounds==null){
				List<Object> listObect = sqlSession.selectList("common.select", parameter);
				listVo.setList(listObect);
				listVo.setTotalSize(-1);
			}else{
				List<Object> listObect = sqlSession.selectList("common.select", parameter, rowBounds);
				listVo.setList(listObect);
				listVo.setTotalSize((Integer)parameter.get("pageCount"));
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} 
		return listVo;
	}
	
	@Override
	public void insert(String statement, Map<String,Object> parameter) throws DaoException {
		try {
			sqlSession.insert(statement, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} 
	}
	
	@Override
	public void insert(String statement, Object parameter) throws DaoException {
		try {
			sqlSession.insert(statement, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} 
	}
	
	@Override
	public void update(String statement, Map<String,Object> parameter) throws DaoException {
		try {
			sqlSession.update(statement, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} 
	}
	
	@Override
	public void delete(String statement, Map<String,Object> parameter) throws DaoException {
		try {
			sqlSession.delete(statement, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} 
	}

	@Override
	public Long insertReturn(String statement, Map<String, Object> parameter) throws DaoException {
		try {
			sqlSession.insert(statement, parameter);
			Long id = (Long) parameter.get("id");
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} 
	}

}
