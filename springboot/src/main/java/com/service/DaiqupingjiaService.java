package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaiqupingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaiqupingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaiqupingjiaView;


/**
 * 代取评价
 *
 * @author 
 * @email 
 */
public interface DaiqupingjiaService extends IService<DaiqupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaiqupingjiaVO> selectListVO(Wrapper<DaiqupingjiaEntity> wrapper);
   	
   	DaiqupingjiaVO selectVO(@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);
   	
   	List<DaiqupingjiaView> selectListView(Wrapper<DaiqupingjiaEntity> wrapper);
   	
   	DaiqupingjiaView selectView(@Param("ew") Wrapper<DaiqupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaiqupingjiaEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<DaiqupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<DaiqupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<DaiqupingjiaEntity> wrapper);



}

