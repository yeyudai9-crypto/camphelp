package com.entity.model;

import com.entity.JiedanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 接单信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 */
public class JiedanxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 快递单号
	 */
	
	private String kuaididanhao;
		
	/**
	 * 快递名称
	 */
	
	private String kuaidimingcheng;
		
	/**
	 * 截图
	 */
	
	private String jietu;
		
	/**
	 * 快递类型
	 */
	
	private String kuaidileixing;
		
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
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 取货地址
	 */
	
	private String quhuodizhi;
		
	/**
	 * 目的地址
	 */
	
	private String mudedizhi;
		
	/**
	 * 配送账号
	 */
	
	private String peisongzhanghao;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 快递状态
	 */
	
	private String kuaidizhuangtai;
		
	/**
	 * 接单时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jiedanshijian;
		
	/**
	 * 配送人
	 */
	
	private String peisongren;
		
	/**
	 * 路线规划
	 */
	
	private String luxianguihua;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：配送账号
	 */
	 
	public void setPeisongzhanghao(String peisongzhanghao) {
		this.peisongzhanghao = peisongzhanghao;
	}
	
	/**
	 * 获取：配送账号
	 */
	public String getPeisongzhanghao() {
		return peisongzhanghao;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：快递状态
	 */
	 
	public void setKuaidizhuangtai(String kuaidizhuangtai) {
		this.kuaidizhuangtai = kuaidizhuangtai;
	}
	
	/**
	 * 获取：快递状态
	 */
	public String getKuaidizhuangtai() {
		return kuaidizhuangtai;
	}
				
	
	/**
	 * 设置：接单时间
	 */
	 
	public void setJiedanshijian(Date jiedanshijian) {
		this.jiedanshijian = jiedanshijian;
	}
	
	/**
	 * 获取：接单时间
	 */
	public Date getJiedanshijian() {
		return jiedanshijian;
	}
				
	
	/**
	 * 设置：配送人
	 */
	 
	public void setPeisongren(String peisongren) {
		this.peisongren = peisongren;
	}
	
	/**
	 * 获取：配送人
	 */
	public String getPeisongren() {
		return peisongren;
	}
				
	
	/**
	 * 设置：路线规划
	 */
	 
	public void setLuxianguihua(String luxianguihua) {
		this.luxianguihua = luxianguihua;
	}
	
	/**
	 * 获取：路线规划
	 */
	public String getLuxianguihua() {
		return luxianguihua;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
