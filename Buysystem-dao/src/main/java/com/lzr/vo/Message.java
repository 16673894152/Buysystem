package com.lzr.vo;

/**
 * 后台返回前端的消息,包含一个flag和msg消息
 * 通常用于前台请求后台操作,后台返回是否成功
 *
 * 用于Controller层的返回值
 * @author 李锦程
 */
public class Message {

    /**
     * 该操作是执行否成功
     */
    public Boolean flag;

    /**
     * 操作返回的消息, 该消息可以是字符串, 对象等
     */
    public Object msg;


    public Message(Boolean flag, Object msg) {
        this.flag = flag;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                '}';
    }
}
