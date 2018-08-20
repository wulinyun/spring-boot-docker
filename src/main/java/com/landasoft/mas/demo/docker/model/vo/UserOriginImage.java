package com.landasoft.mas.demo.docker.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户脸部照片实体
 * 
 * @author wulinyun
 * @version 2017年9月8日下午1:53:41
 */
public class UserOriginImage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id; 			// 主键uuid
	private String userId; 		// 用户id
	private String imageId; 	// 公有云图片Id
	private Integer type = 0; 	// 0 正面 1侧面....暂时demo使用正面
	@JsonFormat(/*timezone = "GMT+8", *//*pattern = "yyyy-MM-dd HH:mm:ss"*/)
	private Date createTime; 	// 创建时间
	@JsonFormat(/*timezone = "GMT+8",*//* pattern = "yyyy-MM-dd HH:mm:ss"*/)
	private Date updateTime; 	// 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
