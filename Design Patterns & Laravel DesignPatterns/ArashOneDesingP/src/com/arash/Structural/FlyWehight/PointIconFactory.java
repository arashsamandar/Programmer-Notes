package com.arash.Structural.FlyWehight;

import java.util.HashMap;
import java.util.Map;

public class PointIconFactory {
    public PointIcon getPointIcon(PointType type) {
        // key -> value
        // PointType -> PointIcon
        Map<PointType,PointIcon> icons = new HashMap<>();
        if(!icons.containsKey(type)) {
            var icon = new PointIcon(type,null);
            icons.put(type,icon);
        }

        return icons.get(type);
    }
}
