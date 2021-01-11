package loggers;

import java.io.Serializable;

public class LogModel implements Serializable {
	/**
	 * 紀錄檔編號
	 */
	private String logId;
	
	/**
	 * 操作人員
	 */
	private String operateUser;
	/**
	 * 操作時間，以yyyy-MM-dd HH:mm:ss的格式紀錄
	 */
	private String operateTime;
	/**
	 * 紀錄檔內容
	 */
	private String logContent;
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	@Override
	public String toString() {
		return "LogModel [logId=" + logId + ", operateUser=" + operateUser + ", operateTime=" + operateTime
				+ ", logContent=" + logContent + "]";
	}
	
}
