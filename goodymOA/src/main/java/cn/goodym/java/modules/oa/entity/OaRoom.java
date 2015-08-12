/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 会议室管理Entity
 * @author 77jubao
 * @version 2015-08-12
 */
public class OaRoom extends DataEntity<OaRoom> {
	
	private static final long serialVersionUID = 1L;
	private String roomName;		// 会议室名称
	private String holdNumber;		// 容纳人数
	private String roomEquipment;		// 会议室设备
	private String roomAddr;		// 会议室地址
	private String status;		// 使用状态
	
	public OaRoom() {
		super();
	}

	public OaRoom(String id){
		super(id);
	}

	@Length(min=0, max=255, message="会议室名称长度必须介于 0 和 255 之间")
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Length(min=0, max=11, message="容纳人数长度必须介于 0 和 11 之间")
	public String getHoldNumber() {
		return holdNumber;
	}

	public void setHoldNumber(String holdNumber) {
		this.holdNumber = holdNumber;
	}
	
	@Length(min=0, max=255, message="会议室设备长度必须介于 0 和 255 之间")
	public String getRoomEquipment() {
		return roomEquipment;
	}

	public void setRoomEquipment(String roomEquipment) {
		this.roomEquipment = roomEquipment;
	}
	
	@Length(min=0, max=255, message="会议室地址长度必须介于 0 和 255 之间")
	public String getRoomAddr() {
		return roomAddr;
	}

	public void setRoomAddr(String roomAddr) {
		this.roomAddr = roomAddr;
	}
	
	@Length(min=0, max=11, message="使用状态长度必须介于 0 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}