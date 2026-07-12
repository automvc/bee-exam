package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Honey
 * Create on 2026-05-06 00:11:09
 */
public class Idclaim implements Serializable {

	private static final long serialVersionUID = 1590687565051L;

	private Integer id;
	private String idflag;
	private String tab;
	private String col;
	private Long maxid;
	private Long claimedamount;
	private LocalDateTime updatetime;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdflag() {
		return idflag;
	}

	public void setIdflag(String idflag) {
		this.idflag = idflag;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public Long getMaxid() {
		return maxid;
	}

	public void setMaxid(Long maxid) {
		this.maxid = maxid;
	}

	public Long getClaimedamount() {
		return claimedamount;
	}

	public void setClaimedamount(Long claimedamount) {
		this.claimedamount = claimedamount;
	}

	public LocalDateTime getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Idclaim[");
		str.append("id=").append(id);
		str.append(",idflag=").append(idflag);
		str.append(",tab=").append(tab);
		str.append(",col=").append(col);
		str.append(",maxid=").append(maxid);
		str.append(",claimedamount=").append(claimedamount);
		str.append(",updatetime=").append(updatetime);
		str.append(",remark=").append(remark);
		str.append("]");
		return str.toString();
	}
}