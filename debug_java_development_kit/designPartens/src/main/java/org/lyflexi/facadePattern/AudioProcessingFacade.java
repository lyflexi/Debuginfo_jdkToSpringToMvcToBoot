package org.lyflexi.facadePattern;

/**
 * @Author: ly
 * @Date: 2024/5/18 14:35
 */
// 外观类
class AudioProcessingFacade {
    private AudioDecoder decoder;
    private AudioEnhancer enhancer;
    private FormatConverter converter;
    public AudioProcessingFacade() {
        this.decoder = new AudioDecoder();
        this.enhancer = new AudioEnhancer();
        this.converter = new FormatConverter();
    }

    // 外观方法，简化客户端调用
    public void process(String file, String format) {
        decoder.decode(file);
        enhancer.enhance();
        converter.convert(format);
        System.out.println("音频处理完成");
    }

}
