/**
 * 
 * 成都铁路局科研所
 * <ul>
 * <li>Author: 焦运磊</li>
 * <li>E-Mail: jylapple@163.com</li>
 * <li>T-Phone: 18628168078</li>
 * <li>Date: 2012-12-11</li>
 * <li>Description:</li>
 * <li>+-History-------------------------------------+</li>
 * <li>| Date Author Description</li>
 * <li>|2012-12-11 焦运磊 Created</li>
 * <li>+------------------------------------------------</li>
 * </ul>
 */
package com.common.constant;

import java.io.File;


/**
 * 系统模块常量文件
 */
public class SystemConstant {

	/** 当前用户 */
	public static final String CURRENT_USER = "user";
	/** 当前用户 */
	public static final String CURRENT_PERSON = "person";
	/** 当前用户所有权限(角色权限+用户权限) */
	public static final String CURRENT_USER_AUTHORITY = "currentUserAuthority";
	/** 当前部门 */
	public static final String CURRENT_UNIT = "unit";
	
	/** 系统日期格式 **/
	public static final String DATE_PATTEN = "yyyy-MM-dd";
	/** 系统时间格式 **/
	public static final String TIME_PATTEN = "yyyy-MM-dd HH:mm:ss";
	
	/** 附件类型-图片 */
	public static final int ATTACH_TYPE_IMAGE = 0;
	/** 附件类型-文档 */
	public static final int ATTACH_TYPE_DOC = 1;
	/** 附件类型-视频 */
	public static final int ATTACH_TYPE_VIDEO = 2;
	/** 附件类型-音频 */
	public static final int ATTACH_TYPE_AUDIO = 3;
	/** 附件类型-其它 */
	public static final int ATTACH_TYPE_OTHER = 4;
	
	/** 上传文件夹-图片 */
	public static final String UPLOAD_FOLDER_IMAGE = "upload" + File.separator + "images";
	/** 上传文件夹-文档 */
	public static final String UPLOAD_FOLDER_DOC = "upload" + File.separator + "docs";
	/** 上传文件夹-视频 */
	public static final String UPLOAD_FOLDER_VIDEO = "upload" + File.separator + "videos";
	/** 上传文件夹-音频 */
	public static final String UPLOAD_FOLDER_AUDIO = "upload" + File.separator + "audios";
	/**手机上传音频文件夹*/
	public static final String UPLOAD_MOBILE_AUDIO = UPLOAD_FOLDER_AUDIO + File.separator + "mobile";
	/**手机上传照片文件夹*/
	public static final String UPLOAD_MOBILE_IMAGE = UPLOAD_FOLDER_IMAGE + File.separator + "mobile";
	/** 上传文件夹-其它 */
	public static final String UPLOAD_FOLDER_OTHER = "upload" + File.separator + "others";
	
	public static final String ACTIVITI_PATH = "activiti";
	
	public static final int 铁路局 = -2;
	public static final int 局目录 = -1;//安监系统代表是专业
	public static final int 处 = 0;
	public static final int 处科室 = 1;
	public static final int 局科室 = 2;//安监系统未使用
	public static final int 段 = 3;
	public static final int 段科室 = 4;
	public static final int 车间 = 5;
	public static final int 工区 = 6;
	public static final int 工作组 = 7;
	public static final int 科室内部单位 = 8;//安监系统未使用

}
