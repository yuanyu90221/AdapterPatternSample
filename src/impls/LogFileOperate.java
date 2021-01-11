package impls;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import interfaces.LogFileOperateApi;
import loggers.LogModel;

public class LogFileOperate implements LogFileOperateApi {
	/**
	 * 紀錄檔的路徑與檔案名稱,預設是根目錄下的AdapterLog.log
	 */

	private String logFilePathName = "AdapterLog.log";

	/**
	 * Constructor: 傳入檔案的路徑跟名稱
	 * 
	 * @param logFilePathName
	 */
	public LogFileOperate(String logFilePathName) {
		if (logFilePathName != null && logFilePathName.trim().length() > 0) {
			this.logFilePathName = logFilePathName;
		}
	}

	@Override
	public List<LogModel> readLogFile() {
		List<LogModel> list = null;
		ObjectInputStream oin = null;
		try {
			File f = new File(logFilePathName);
			if (f.exists()) {
				oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			}
			list = (List<LogModel>)oin.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oin != null) {
					oin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void writeLogFile(List<LogModel> list) {
		File f = new File(logFilePathName);
		ObjectOutputStream oout = null;
		try {
			oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oout.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
