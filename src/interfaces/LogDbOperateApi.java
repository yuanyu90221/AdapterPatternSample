package interfaces;
import java.util.List;
import loggers.LogModel;
// v2 interface
public interface LogDbOperateApi {
	/**
	 * 新增紀錄檔
	 * @param lm 需要新增的紀錄檔物件
	 */
	public void createLog(LogModel lm);
	/**
	 * 修改紀錄檔
	 * @param lm 需要修改的紀錄檔物件
	 */
	public void updateLog(LogModel lm);
	/**
	 * 刪除紀錄檔
	 * @param lm 需要刪除的紀錄檔物件
	 */
	public void removeLog(LogModel lm);
	/***
	 * 獲得所有的紀錄檔
	 * @return 所有的紀錄檔物件
	 */
	public List<LogModel> getAllLog();
}
