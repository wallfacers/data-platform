package com.wallfacers.data.platform.stub.service.menu;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wallfacers.data.platform.dao.model.MenuDO;

import java.util.Collection;

/**
 * 菜单 Service
 *
 * @author wallfacers
 */
public interface MenuService extends IService<MenuDO> {

    /**
     * 获取升序的菜单列表
     *
     * @return 菜单列表
     */
    Collection<MenuDO> listEnabledMenuBySortAsc();
    
}
