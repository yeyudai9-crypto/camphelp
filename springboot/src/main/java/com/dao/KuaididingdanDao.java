package com.dao;

import com.entity.KuaididingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KuaididingdanVO;
import com.entity.view.KuaididingdanView;


/**
 * 代取订单
 * 
 * @author 
 * @email 
 */
public interface KuaididingdanDao extends BaseMapper<KuaididingdanEntity> {
	
	List<KuaididingdanVO> selectListVO(@Param("ew") Wrapper<KuaididingdanEntity> wrapper);
	
	KuaididingdanVO selectVO(@Param("ew") Wrapper<KuaididingdanEntity> wrapper);
	
	List<KuaididingdanView> selectListView(@Param("ew") Wrapper<KuaididingdanEntity> wrapper);

	List<KuaididingdanView> selectListView(Pagination page,@Param("ew") Wrapper<KuaididingdanEntity> wrapper);

	
	KuaididingdanView selectView(@Param("ew") Wrapper<KuaididingdanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KuaididingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KuaididingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KuaididingdanEntity> wrapper);



}
