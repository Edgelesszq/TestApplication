package com.testapplication.base;

/**
 * @author mjkj
 * @description
 * @data 2018/12/26 10:28
 */
public class DataModel {

    public static BaseModel request(String token){

        // 声明一个空的BaseModel
        BaseModel model = null;

        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel)Class.forName(token).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }

}
