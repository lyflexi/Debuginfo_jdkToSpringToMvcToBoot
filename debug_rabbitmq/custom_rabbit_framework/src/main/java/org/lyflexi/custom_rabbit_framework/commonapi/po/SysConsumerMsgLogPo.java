package org.lyflexi.custom_rabbit_framework.commonapi.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 13:50
 */

@Builder
@Data
@TableName("t_sys_consumer_msg_log")
public class SysConsumerMsgLogPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String msgId;

    private String dataId;

    private Long dataVersion;

    private String msg;

    private String exchange;

    private String routingKey;

    private String queue;

    private Integer status;

    private Integer tryCount;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime addTime;

    @TableField(fill = FieldFill.INSERT)
    private String addUserName;

    @TableField(fill = FieldFill.INSERT)
    private String addUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUserName;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime editTime;

    @TableField(fill = FieldFill.INSERT)
    private Integer dataStatus;

    @TableField(fill = FieldFill.INSERT)
    private String factoryCode;
}
