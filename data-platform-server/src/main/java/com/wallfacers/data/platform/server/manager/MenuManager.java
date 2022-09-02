package com.wallfacers.data.platform.server.manager;

import com.wallfacers.data.platform.dao.model.MenuDO;
import com.wallfacers.data.platform.model.bo.MenuBO;
import com.wallfacers.data.platform.server.util.TreeUtil;
import com.wallfacers.data.platform.stub.service.menu.MenuService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.wallfacers.data.platform.common.AbstractCopyUtils.copyCollection;

/**
 * 菜单 Manager
 *
 * @author wallfacers
 */
@Service
public class MenuManager {

    private final MenuService menuService;

    public MenuManager(MenuService menuService) {
        this.menuService = menuService;
    }

    public Map<String, Object> getMenuMap() {

        Map<String, Object> menuMap = new HashMap<>(16);

        Collection<MenuDO> menuList = menuService.listEnabledMenuBySortAsc();
        menuMap.put("menuInfo", TreeUtil.toTree(copyCollection(menuList, MenuBO.class), 0L));

        // 首页配置
        menuMap.put("homeInfo", "{title: '首页', href: '/page/welcome-1.html'}}");
        // LOGO配置
        menuMap.put("logoInfo", "{title: 'DATE PLATFORM',image: 'images/logo.png'}");

        return menuMap;
    }


}
