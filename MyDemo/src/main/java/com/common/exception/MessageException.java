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
 * 消息异常
 * 
 *@author 杨建雄
 *@date 2016-2-18
 */
public class MessageException extends BaseException {

	private static final long serialVersionUID = 218079248646545792L;

	public MessageException() {

	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(Throwable throwable) {
		if(throwable instanceof BaseException){
			super.setMessage(((BaseException) throwable).getMessage());
		}
		super.initCause(throwable);
	}

	public MessageException(String message, Throwable throwable) {
		super.setMessage(message);
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
