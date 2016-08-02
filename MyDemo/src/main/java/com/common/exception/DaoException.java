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
 * 数据访问层异常
 * 
 *@author 杨建雄
 *@date 2016-2-18
 */
public class DaoException extends BaseException {

	private static final long serialVersionUID = 8091325756012159334L;

	public DaoException(String message) {
		super.setMessage(message);
	}

	public DaoException(String message, Throwable throwable) {
		super.setMessage(message);
		super.initCause(throwable);
	}

	public DaoException(Throwable throwable) {
		super.setMessage(throwable.getClass().getSimpleName());
		super.initCause(throwable);
	}

	public Throwable getOrignalException() {
		Throwable throwable = this.getCause();
		while(throwable.getCause() != null){
			throwable = throwable.getCause();
		}
		return throwable;
	}

	public String getOrignalMessage() {
		return this.getOrignalException().getClass().getSimpleName();
	}

}
