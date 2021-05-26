package com.ruoyi.record.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础表字段
 */
@Data
public class CommonModel<T extends Model<?>> extends Model<T>  {

	/** 参数主键 */
	@Excel(name = "参数主键", cellType = Excel.ColumnType.NUMERIC)
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/** 参数名称 */
	@Excel(name = "参数名称")
	@TableField("name")
	private String name;
	/** 参数键名 */
	@Excel(name = "参数键名")
	@TableField("sort")
	private String sort;
	/** 创建者 */
//	@Excel(name = "创建者")
	@TableField("user_id")
	private String userId;
	/** 创建者 */
//	@Excel(name = "创建者")
	@TableField("create_by")
	private String createBy;
	/** 创建时间 */
	@Excel(name = "创建时间")
	@TableField("create_time")
	private Date createTime;
	/** 修改者 */
//	@Excel(name = "修改者")
	@TableField("update_by")
	private String updateBy;
	/** 修改时间 */
//	@Excel(name = "修改时间")
	@TableField("update_time")
	private Date updateTime;
	/** 备注 */
	@Excel(name = "备注")
	@TableField("remark")
	private String remark;

	/**
	 * 当前页
	 */
	@TableField(exist = false)
	private String pageNum;
	/**
	 * 每页数量
	 */
	@TableField(exist = false)
	private String pageSize;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
