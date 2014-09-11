package com.miles.wechat.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * XML的辅助工具类
 *
 * @author miles
 * @datetime 2014/5/21 22:35
 */
public class XmlUtils {
    /**
     * 将一个实体类对象转成xml字符串
     *
     * @param entity 实体类对象
     * @param <T>    实体类对象的类型
     * @return xml字符串
     */
    public static <T> String toXml(T entity, Class<T> clazz) {
        if (entity == null) {
            throw new IllegalArgumentException("将java对象转成XML字符串时,没有获得java对象!");
        }
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(entity, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将xml转成指定的实体类
     *
     * @param xml   xml字符串
     * @param clazz 实体类类型
     * @param <T>   泛型
     * @return 实体类对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromXml(String xml, Class<T> clazz) {
        if (StringUtils.isEmpty(xml)) {
            throw new IllegalArgumentException("将XML转成java对象时,没有获得xml的内容!");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("将XML转成java对象时,没有java对象的类型!");
        }
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXml(InputStream inputStream, Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
