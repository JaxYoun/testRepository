package com.entity.demo;

import com.sckj.macb.comment.Entity;
import com.sckj.macb.comment.Field;
import com.sckj.macb.comment.FieldType;
import com.sckj.macb.comment.Id;

@Entity(tableName = "t_macb_entity")
public class MacbEntity {

	@Id
	private String id;
	
	@Field(field = "name", type=FieldType.TEXT, length=32)
	private String name;
	
	@Field(field = "age", type=FieldType.INT)
	private Integer age;
	
	@Field(field = "income", type=FieldType.DOUBLE, precison=3, length=10)
	private Double income;
}
