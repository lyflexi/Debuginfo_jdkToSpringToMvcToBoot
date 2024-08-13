package org.lyflexi.custom_rabbit_framework.commonapi.message;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.Data;
import org.lyflexi.custom_rabbit_framework.commonapi.utils.Assert;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 13:25
 */

@Data
public abstract class BaseMessageData implements IMessageData {

    public BaseMessageData() {
        this.seqNo = IdWorker.getIdStr();
    }

    /**
     * 消息全局流水号，生产者产生
     */
    private String seqNo;

    /**
     * 消息版本
     */
    private Long version = 0L;

    /**
     * 事件ID
     */
    //"工厂编码"
    private String factoryCode;

    @Override
    public void assertParams() {
        Assert.notBlack(seqNo, "全局流水号不能为空！");
        Assert.notBlack(factoryCode, "工厂编码不能为空！");
    }
}
