package com.wallfacers.data.platform.web.controller.menu;

import com.wallfacers.data.platform.model.vo.ResponseVO;
import com.wallfacers.data.platform.server.manager.MenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/api/data/platform/menu")
public class MenuController {

    @Autowired
    private MenuManager menuManager;

    /**
     * 获取菜单列表
     *
     * @return 菜单列表
     */
    @PostMapping("/list")
    public ResponseVO<Map<String, Object>> list() {
        return ResponseVO.success(menuManager.getMenuMap());
    }

}
