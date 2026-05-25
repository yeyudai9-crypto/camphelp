package com.entity.vo;

import com.entity.KuaididingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 代取订单
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 */
public class KuaididingdanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
