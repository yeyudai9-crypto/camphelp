package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 快递订单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("kuaididingdan")
public class KuaididingdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KuaididingdanEntity() {
		
	}
	
	public KuaididingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 快递单号
	 */
					
	private String kuaididanhao;
	
	/**
	 * 快递名称
	 */
					
	private String kuaidimingcheng;
	
	/**
	 * 快递类型
	 */
					
	private String kuaidileixing;
	
	/**
	 * 截图
	 */
					
	private String jietu;
	
	/**
	 * 快递备注
	 */
					
	private String kuaidibeizhu;
	
	/**
	 * 代取费用
	 */
					
	private Double daiqufeiyong;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 目的地址
	 */
					
	private String mudedizhi;
	
	/**
	 * 取货地址
	 */
					
	private String quhuodizhi;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：快递单号
	 */
	public void setKuaididanhao(String kuaididanhao) {
		this.kuaididanhao = kuaididanhao;
	}
	/**
	 * 获取：快递单号
	 */
	public String getKuaididanhao() {
		return kuaididanhao;
	}
	/**
	 * 设置：快递名称
	 */
	public void setKuaidimingcheng(String kuaidimingcheng) {
		this.kuaidimingcheng = kuaidimingcheng;
	}
	/**
	 * 获取：快递名称
	 */
	public String getKuaidimingcheng() {
		return kuaidimingcheng;
	}
	/**
	 * 设置：快递类型
	 */
	public void setKuaidileixing(String kuaidileixing) {
		this.kuaidileixing = kuaidileixing;
	}
	/**
	 * 获取：快递类型
	 */
	public String getKuaidileixing() {
		return kuaidileixing;
	}
	/**
	 * 设置：截图
	 */
	public void setJietu(String jietu) {
		this.jietu = jietu;
	}
	/**
	 * 获取：截图
	 */
	public String getJietu() {
		return jietu;
	}
	/**
	 * 设置：快递备注
	 */
	public void setKuaidibeizhu(String kuaidibeizhu) {
		this.kuaidibeizhu = kuaidibeizhu;
	}
	/**
	 * 获取：快递备注
	 */
	public String getKuaidibeizhu() {
		return kuaidibeizhu;
	}
	/**
	 * 设置：代取费用
	 */
	public void setDaiqufeiyong(Double daiqufeiyong) {
		this.daiqufeiyong = daiqufeiyong;
	}
	/**
	 * 获取：代取费用
	 */
	public Double getDaiqufeiyong() {
		return daiqufeiyong;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：目的地址
	 */
	public void setMudedizhi(String mudedizhi) {
		this.mudedizhi = mudedizhi;
	}
	/**
	 * 获取：目的地址
	 */
	public String getMudedizhi() {
		return mudedizhi;
	}
	/**
	 * 设置：取货地址
	 */
	public void setQuhuodizhi(String quhuodizhi) {
		this.quhuodizhi = quhuodizhi;
	}
	/**
	 * 获取：取货地址
	 */
	public String getQuhuodizhi() {
		return quhuodizhi;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
