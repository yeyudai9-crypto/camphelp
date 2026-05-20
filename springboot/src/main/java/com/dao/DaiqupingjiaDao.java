package com.dao;

import com.entity.DaiqupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaiqupingjiaVO;
import com.entity.view.DaiqupingjiaView;


/**
 * 代取评价
 * 
 * @author 
 * @email 
 */
public interface DaiqupingjiaDao extends BaseMapper<DaiqupingjiaEntity> {
	
	List<DaiqupingjiaVO> selectListVO(@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);
	
	DaiqupingjiaVO selectVO(@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);
	
	List<DaiqupingjiaView> selectListView(@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);

	List<DaiqupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);

	
	DaiqupingjiaView selectView(@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);



}
