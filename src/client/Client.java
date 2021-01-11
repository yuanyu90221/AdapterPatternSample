package client;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import impls.Adapter;
import impls.LogFileOperate;
import interfaces.LogDbOperateApi;
import interfaces.LogFileOperateApi;
import loggers.LogModel;

public class Client {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		// 準備紀錄檔內容,也就是測試的資料
		LogModel lml = new LogModel();
		lml.setLogId("001");
		lml.setOperateUser("admin");
		lml.setOperateTime(sdf.format(calendar.getTime()));
		lml.setLogContent("這唯一測試");
		
		List<LogModel> list = new ArrayList<LogModel>();
		list.add(lml);
		// 建立操作紀錄檔的物件
		LogFileOperateApi logFileApi = new LogFileOperate("");
		LogDbOperateApi api = new Adapter(logFileApi);
		// 儲存紀錄檔
//		api.writeLogFile(list);
		api.createLog(lml);
		// 讀取記憶檔內容
//		List<LogModel> readLog = api.readLogFile();
		List<LogModel> readLog = api.getAllLog();
		System.out.println("readLog="+readLog);
	}

}
