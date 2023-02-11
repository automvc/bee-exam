package org.teasoft.exam.bee.mongodb.json.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Honey
 * Create on 2023-02-06 16:11:47
 */
public class Size implements Serializable {

	private static final long serialVersionUID = 1591692288480L;

	private String uom;
	private BigDecimal w;
	private Double h;

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getW() {
		return w;
	}

	public void setW(BigDecimal w) {
		this.w = w;
	}

//	public Integer getH() {
//		return h;
//	}
//
//	public void setH(Integer h) {
//		this.h = h;
//	}
	
	@Override
	public String toString() {
		return "Size [uom=" + uom + ", w=" + w + ", h=" + h + "]";
	}

	public Double getH() {
		return h;
	}

	public void setH(Double h) {
		this.h = h;
	}

}