package interfaces;
import java.util.List;
import loggers.LogModel;
//v1 interace
public interface LogFileOperateApi {
	/**
	 * 讀取紀錄檔,從檔案裡面獲得儲存的記憶檔列表物件
	 * @return 儲存的紀錄倒列表物件
	 */
	public List<LogModel> readLogFile();
	/**
	 * 寫紀錄檔，把紀錄檔列表寫出到紀錄檔中去
	 * @param list 要寫到記憶體的紀錄檔列表
	 */
	public void writeLogFile(List<LogModel> list);
}
