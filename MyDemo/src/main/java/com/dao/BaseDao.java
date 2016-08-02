/**
 * 
 */
package com.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Youn
 *
 */
public class BaseDao {

	@Autowired
	protected SqlSessionTemplate sqlSession;
}
