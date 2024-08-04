package org.lyflexi.facadePattern;

/**
 * @Author: ly
 * @Date: 2024/5/18 14:35
 */
// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 创建外观对象
        AudioProcessingFacade facade = new AudioProcessingFacade();
        // 调用外观方法进行音频处理
        facade.process("audio.mp3", "wav");
    }
}