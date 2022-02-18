package com.prdcv.learnspring.dto;


import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class UserResponseDto<T> {
    private String userName;
    private String userFullName;
    private String userSettingType;
    private String userSettingValue;
    public T getUserSetting(){
        switch(userSettingType) {
            case "STR":
                return (T) userSettingValue;
            case "INT":
                return (T) Integer.valueOf(userSettingValue);
            case "FLOAT":
                return (T) Float.valueOf(userSettingValue);
            case "BOOL":
                return (T) (Object) userSettingValue.equalsIgnoreCase("True");
            default:
                throw new ClassCastException();
        }
    }
}

