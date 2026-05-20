package com.dao;

import com.entity.SongdadingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SongdadingdanVO;
import com.entity.view.SongdadingdanView;


/**
 * 送达订单
 * 
 * @author 
 * @email 
 */
public interface SongdadingdanDao extends BaseMapper<SongdadingdanEntity> {
	
	List<SongdadingdanVO> selectListVO(@Param("ew") Wrapper<SongdadingdanEntity> wrapper);
	
	SongdadingdanVO selectVO(@Param("ew") Wrapper<SongdadingdanEntity> wrapper);
	
	List<SongdadingdanView> selectListView(@Param("ew") Wrapper<SongdadingdanEntity> wrapper);

	List<SongdadingdanView> selectListView(Pagination page,@Param("ew") Wrapper<SongdadingdanEntity> wrapper);

	
	SongdadingdanView selectView(@Param("ew") Wrapper<SongdadingdanEntity> wrapper);
	

}
