/**
 * 
 */
package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.IMybatisDao;

/**
 * @author Youn
 *
 */
public class BaseService {

	@Autowired
	protected IMybatisDao mybatisDao;

}
