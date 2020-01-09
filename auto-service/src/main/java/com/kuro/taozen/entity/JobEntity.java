package com.kuro.taozen.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.kuro.taozen.consts.DBCollectionConstants.JOB_ENTITY;
import static com.kuro.taozen.consts.DBFieldConstants.*;

/**
 * 作业实体
 *
 * @author kuro
 * @create 2020-01-09
 **/
@Data
@Document(collation = JOB_ENTITY)
public class JobEntity {
	@Id
	private String id;
	/**
	 * 名称
	 */
	@Field(NAME)
	private String name;
	/**
	 * 说明
	 */
	@Field(DESC)
	private String desc;
	/**
	 * 分类
	 */
	@Field(CATEGORY)
	private List<String> category;
	/**
	 * 类型
	 */
	@Field(TYPE)
	private String type;
	/**
	 * 内容
	 */
	@Field(CONTENT)
	private String content;
	/**
	 * 参数
	 */
	@Field(ARGS)
	private String args;
	/**
	 * 更新时间
	 */
	@Field(UPDATE_TIME)
	private Long updateTime;
	/**
	 * 更新人
	 */
	@Field(UPDATE_USER)
	private String updateUser;
	/**
	 * 创建时间
	 */
	@Field(CREATED_TIME)
	private Long createdTime;
	/**
	 * 创建人
	 */
	@Field(CREATED_USER)
	private String createdUser;
}
