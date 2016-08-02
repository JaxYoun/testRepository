/**
 * 
 */
package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.common.exception.DaoException;
import com.common.vo.ListVo;

/**
 * @author Youn
 *
 */
public interface IMybatisDao {
	
	public Object getObjectByID(String statement,int id) throws DaoException;

	public List<Object> getObjectList(String statement,Object parameter) throws DaoException;
	
	public List<Object> getObjectList(Map<String,Object> parameter) throws DaoException;
	
	public ListVo<Object> getObjectPage(String statement, Map<String,Object> parameter ,RowBounds rowBounds) throws DaoException;
	
	public ListVo<Object> getObjectPage(Map<String,Object> parameter ,RowBounds rowBounds) throws DaoException;

	public void update(String statement, Map<String, Object> parameter) throws DaoException;

	public void delete(String statement, Map<String, Object> parameter) throws DaoException;

	public void insert(String statement, Map<String, Object> parameter) throws DaoException;
	
	public void insert(String statement, Object parameter) throws DaoException;
	
	public Object getObjectByMap(String statement, Map<String, Object> paramMap) throws DaoException;

	public Object getUniqueObject(String statement, Object object) throws DaoException;
	
	public Long insertReturn(String statement, Map<String, Object> parameter) throws DaoException;
	
}
