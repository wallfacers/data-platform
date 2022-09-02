package com.wallfacers.data.platform.server.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wallfacers.data.platform.dao.mapper.MenuMapper;
import com.wallfacers.data.platform.dao.model.MenuDO;
import com.wallfacers.data.platform.enums.DeletedEnum;
import com.wallfacers.data.platform.stub.service.menu.MenuService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 菜单 Service 实现
 *
 * @author wallfacers
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements MenuService {


    @Override
    public Collection<MenuDO> listEnabledMenuBySortAsc() {
        LambdaQueryWrapper<MenuDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MenuDO::getStatus, true);
        queryWrapper.eq(MenuDO::getDeleted, DeletedEnum.UNDELETED);
        queryWrapper.orderByAsc(MenuDO::getSort);
        return this.baseMapper.selectList(queryWrapper);
    }

}
