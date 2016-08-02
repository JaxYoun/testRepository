/**
 * 
 * 成都铁路局科研所
 * <ul>
 * <li>Author: 		杨建雄</li>
 * <li>Date: 		2016-2-18</li>
 * <li>Description:	 </li>
 * <li>+-History-------------------------------------+</li>
 * <li>| Date		Author		Description	</li>
 * <li>|2016-2-18     杨建雄	    Created</li>
 * <li>+------------------------------------------------</li>
 * </ul>
 */
package com.common.exception;

/**
 * 类注释
 * 
 *@author 杨建雄
 *@date 2016-2-18
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 5224429725078867282L;
	
	private String message;
	
	public BaseException() {
		super();
	}
	
	public BaseException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public BaseException(Throwable throwable) {
		super(throwable);
	}
	
	public BaseException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
