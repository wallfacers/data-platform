package com.wallfacers.data.platform.server.util;

import com.wallfacers.data.platform.model.bo.MenuBO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class TreeUtil {

    public static Collection<MenuBO> toTree(Collection<MenuBO> treeList, Long pid) {
        if (CollectionUtils.isEmpty(treeList)) {
            return Collections.emptyList();
        }

        Collection<MenuBO> retList = new ArrayList<>();
        for (MenuBO parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }

    private static MenuBO findChildren(MenuBO parent, Collection<MenuBO> treeList) {
        for (MenuBO child : treeList) {
            if (parent.getId().equals(child.getPid())) {
                if (Objects.isNull(parent.getChildList())) {
                    parent.setChildList(new ArrayList<>());
                }
                parent.getChildList().add(findChildren(child, treeList));
            }
        }
        return parent;
    }

}