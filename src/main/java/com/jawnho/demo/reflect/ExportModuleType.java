package com.jawnho.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExportModuleType {

    /**
     * 默认类型，老游戏还没有更新，因此上传的数据没有该字段
     */
    public static final int DEFAULT_TYPE = -1;

    /**
     * 轮播Icon导出模块
     */
    public static final int CAROUSEL_BUTTON = 1;

    /**
     * 九宫格盒子导出模块
     */
    public static final int MORE_GAME = 2;

    /**
     * 猜你喜欢模块
     */
    public static final int HORIZONTA_GAME_BOX = 3;

    /**
     * 通关盒子导出模块
     */
    public static final int PASS_MORE_GAME = 4;

    /**
     * 全屏盒子导出模块
     */
    public static final int NEW_MORE_GAME = 5;

    /**
     * 过关盒子导出模块
     */
    public static final int PASS_PART_MORE_GAME = 6;


    /**
     * type是否有效
     */
    public static boolean isValid(int type) {

        return list.contains(type);
    }

    private static List<Integer> list = new LinkedList<>();

    //获取到所有的public static final int 的值
    static {
        Field[] fields = ExportModuleType.class.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            Class<?> type1 = field.getType();
            if (Modifier.isPublic(modifiers)
                    && Modifier.isStatic(modifiers)
                    && Modifier.isFinal(modifiers)
                    && type1.getName().equals("int")) {
                try {
                    String s = field.get(null).toString();
                    list.add(Integer.parseInt(s));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(ExportModuleType.isValid(5));
    }
}
