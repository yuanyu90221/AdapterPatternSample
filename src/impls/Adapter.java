package impls;

import java.util.List;

import interfaces.LogDbOperateApi;
import interfaces.LogFileOperateApi;
import loggers.LogModel;

public class Adapter implements LogDbOperateApi {
	/**
	 * 持有需要被轉換的介面
	 */
	private LogFileOperateApi adaptee;

	/**
	 * Constructor:傳入需要被轉換的物件
	 * @param adaptee 需要被轉換的物件
	 */
	public Adapter(LogFileOperateApi adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void createLog(LogModel lm) {
		// 1: 先讀取檔案內容
		List<LogModel> list = adaptee.readLogFile();
		// 2: 加入新的紀錄檔案物件
		list.add(lm);
		// 3: 重新寫入檔案
		adaptee.writeLogFile(list);
	}

	@Override
	public void updateLog(LogModel lm) {
		// 1: 先讀取檔案內容
		List<LogModel> list = adaptee.readLogFile();
		// 2: 修改對應的紀錄檔案物件
		for(int i=0; i < list.size(); i++) {
			if (list.get(i).getLogId().contentEquals(lm.getLogId())) {
				list.set(i, lm);
				break;
			}
		}
		// 3: 重新寫入檔案
		adaptee.writeLogFile(list);
	}

	@Override
	public void removeLog(LogModel lm) {
		// 1: 先讀取檔案內容
		List<LogModel> list = adaptee.readLogFile();
		// 2: 刪除對應的紀錄檔案物件
		list.remove(lm);
		// 3: 重新寫入檔案
		adaptee.writeLogFile(list);
	}

	@Override
	public List<LogModel> getAllLog() {
		return adaptee.readLogFile();
	}
	
}
