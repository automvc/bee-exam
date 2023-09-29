//package entity;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import java.math.BigDecimal;
//import lombok.Getter;
//import lombok.Setter;
//
///**
// * 订单表
// * @author Honey
// * Create on 2023-08-29 16:46:09
// */
//@Setter
//@Getter
//@ApiModel(description = "订单表") 
//public class Orders {
//
//	@ApiModelProperty(value = "id")
//	private Long id;
//	// 用户ID
//	@ApiModelProperty(value = "用户ID", required = true)
//	private String userid;
//	// 订单ID
//	@ApiModelProperty(value = "订单ID")
//	private Long orderid;
//	@ApiModelProperty(value = "name")
//	private String name;
//	@ApiModelProperty(value = "total")
//	private BigDecimal total;
//	@ApiModelProperty(value = "createtime")
//	private String createtime;
//	@ApiModelProperty(value = "remark")
//	private String remark;
//	@ApiModelProperty(value = "sequence")
//	private String sequence;
//	@ApiModelProperty(value = "abc")
//	private String abc;
//	@ApiModelProperty(value = "updatetime")
//	private String updatetime;
//
//}