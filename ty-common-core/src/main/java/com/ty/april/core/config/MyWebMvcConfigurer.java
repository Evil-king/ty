package com.ty.april.core.config;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ty.april.common.tool.api.ApiResult;
import com.ty.april.common.tool.api.ResultEnum;
import com.ty.april.common.tool.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: wenqing
 * @date: 2017/7/7 09:22
 * @description: Spring MVC 配置
 */
@Slf4j
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    public MyWebMvcConfigurer(){
        log.info("这是Core包下的MyWebMvcConfigurer的构造方法");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
        //解决Long转json精度丢失的问题
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        // 兼容SpringBoot Actuator健康检查端点MediaType
        fastMediaTypes.add(MyMediaType.APPLICATION_ACTUATOR_JSON);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //5.将convert添加到converters当中.
        converters.add(fastJsonHttpMessageConverter);
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add((httpServletRequest, httpServletResponse, o, e) -> {
            ApiResult apiResult;
            // Hibernate Validator参数校验异常
            if (e instanceof MethodArgumentNotValidException) {
                MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
                String msg = methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
                log.error("参数校验失败>>>{}", msg);
                apiResult = ApiResult.badParam(msg);
            } else if (e instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) e;
                Integer code = serviceException.getCode() == null ? ResultEnum.BUSINESS_ERROE.getCode() : serviceException.getCode();
                log.error("业务异常,code={},msg={}", code, serviceException.getMessage());
                apiResult = new ApiResult(code, serviceException.getMessage());
            } else {
                log.error("系统错误", e);
                apiResult = ApiResult.error();
            }
            responseResult(httpServletResponse, apiResult);
            return new ModelAndView();
        });
    }

    private void responseResult(HttpServletResponse response, ApiResult result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
