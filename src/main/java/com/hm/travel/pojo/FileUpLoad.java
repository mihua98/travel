package com.hm.travel.pojo;

import lombok.Data;

/**
 * @author: xiaomikasa
 * @date: 2019/8/28
 */
@Data
public class FileUpLoad {
    /**
     * 0 表示上传失败，1 表示上传成功
     */
    private Integer success;
    /**
     * 提示的信息，上传成功或上传失败及错误信息等
     */
    private String message;
    /**
     * 图片地址
     * 上传成功时才返回
     */
    private String url;
}
