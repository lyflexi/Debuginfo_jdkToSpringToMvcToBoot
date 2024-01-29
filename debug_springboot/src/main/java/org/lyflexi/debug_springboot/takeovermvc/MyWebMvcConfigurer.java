package org.lyflexi.debug_springboot.takeovermvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lfy
 * @Description
 * @create 2023-04-10 17:24
 */
//修改mvc的默认配置，手自一体化mvc
@Configuration //这是一个配置类,给容器中放一个 WebMvcConfigurer 组件，就能自定义底层
public class MyWebMvcConfigurer  /*implements WebMvcConfigurer*/ {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override //配置静态资源
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/a/", "classpath:/b/")
                        .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
            }

            @Override //配置拦截器
            public void addInterceptors(InterceptorRegistry registry) {

            }

            @Override //配置一个能把对象转为yaml的messageConverter
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyYamlHttpMessageConverter());
            }
        };
    }
    public class MyYamlHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

        private ObjectMapper objectMapper = null; //把对象转成yaml

        public MyYamlHttpMessageConverter(){
            //告诉SpringBoot这个MessageConverter支持哪种媒体类型  //媒体类型
            super(new MediaType("text", "yaml", Charset.forName("UTF-8")));
            YAMLFactory factory = new YAMLFactory()
                    .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
            this.objectMapper = new ObjectMapper(factory);
        }

        @Override
        protected boolean supports(Class<?> clazz) {
            //只要是对象类型，不是基本类型
            return true;
        }

        @Override  //@RequestBody
        protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
            return null;
        }

        @Override //@ResponseBody 把对象怎么写出去
        protected void writeInternal(Object methodReturnValue, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

            //try-with写法，自动关流
            try(OutputStream os = outputMessage.getBody()){
                this.objectMapper.writeValue(os,methodReturnValue);
            }

        }
    }
}
