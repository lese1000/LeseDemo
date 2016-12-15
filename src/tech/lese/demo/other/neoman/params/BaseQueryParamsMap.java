package tech.lese.demo.other.neoman.params;

import java.util.HashMap;

public class BaseQueryParamsMap extends HashMap<String, Object>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3445801299906699908L;
	/*protected Object iPage;//页次，默认1
	protected Object iPagePer;//每页记录数，默认值0，有效值0-1000,(0 表示仅返回记录总数)
	protected Object dqBDate;//查询记录筛选：开始日期
	protected Object dqEDate;//查询记录筛选：结束日期
*/	
	public void setiPage(Object iPage) {
		this.put("iPage",iPage );
	}
	public void setiPagePer(Object iPagePer) {
		this.put("iPagePer",iPagePer );
	}
	public void setDqBDate(Object dqBDate) {
		this.put("dqBDate", dqBDate);
	}
	public void setDqEDate(Object dqEDate) {
		this.put("dqEDate", dqEDate);
	}
	
	

}
