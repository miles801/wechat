package com.miles.wechat.message.model;

/**
 * 用在属性或者get方法上面，表示该属性不能够为空
 *
 * @author Michael
 */

public @interface NotNull {
    public boolean value() default true;
}
