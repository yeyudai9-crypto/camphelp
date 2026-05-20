package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SongdadingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SongdadingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SongdadingdanView;


/**
 * 送达订单
 *
 * @author 
 * @email 
 */
public interface SongdadingdanService extends IService<SongdadingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SongdadingdanVO> selectListVO(Wrapper<SongdadingdanEntity> wrapper);
   	
   	SongdadingdanVO selectVO(@Param("ew") Wrapper<SongdadingdanEntity> wrapper);
   	
   	List<SongdadingdanView> selectListView(Wrapper<SongdadingdanEntity> wrapper);
   	
   	SongdadingdanView selectView(@Param("ew") Wrapper<SongdadingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SongdadingdanEntity> wrapper);

   	

}

