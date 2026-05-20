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


import com.dao.SongdadingdanDao;
import com.entity.SongdadingdanEntity;
import com.service.SongdadingdanService;
import com.entity.vo.SongdadingdanVO;
import com.entity.view.SongdadingdanView;

@Service("songdadingdanService")
public class SongdadingdanServiceImpl extends ServiceImpl<SongdadingdanDao, SongdadingdanEntity> implements SongdadingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SongdadingdanEntity> page = this.selectPage(
                new Query<SongdadingdanEntity>(params).getPage(),
                new EntityWrapper<SongdadingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SongdadingdanEntity> wrapper) {
		  Page<SongdadingdanView> page =new Query<SongdadingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SongdadingdanVO> selectListVO(Wrapper<SongdadingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SongdadingdanVO selectVO(Wrapper<SongdadingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SongdadingdanView> selectListView(Wrapper<SongdadingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SongdadingdanView selectView(Wrapper<SongdadingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
