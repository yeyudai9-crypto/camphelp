package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DaiqupingjiaDao;
import com.entity.DaiqupingjiaEntity;
import com.service.DaiqupingjiaService;
import com.entity.vo.DaiqupingjiaVO;
import com.entity.view.DaiqupingjiaView;

@Service("daiqupingjiaService")
public class DaiqupingjiaServiceImpl extends ServiceImpl<DaiqupingjiaDao, DaiqupingjiaEntity> implements DaiqupingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaiqupingjiaEntity> page = this.selectPage(
                new Query<DaiqupingjiaEntity>(params).getPage(),
                new EntityWrapper<DaiqupingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaiqupingjiaEntity> wrapper) {
		  Page<DaiqupingjiaView> page =new Query<DaiqupingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DaiqupingjiaVO> selectListVO(Wrapper<DaiqupingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaiqupingjiaVO selectVO(Wrapper<DaiqupingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaiqupingjiaView> selectListView(Wrapper<DaiqupingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaiqupingjiaView selectView(Wrapper<DaiqupingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<DaiqupingjiaEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<DaiqupingjiaEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<DaiqupingjiaEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
