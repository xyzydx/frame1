package com.spring.ext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class PropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {
    private Resource rootLocation;
    private Properties properties;
    private String[] childLocations;


    public Resource getRootLocation() {
        return rootLocation;
    }

    public void setRootLocation(Resource rootLocation) {
        this.rootLocation = rootLocation;
        properties = new Properties();
        InputStream in = null;
        try {
            in = rootLocation.getInputStream();
            properties.load(in);
            for (Object key : properties.keySet()) {
                if (System.getProperty((String) key) == null) {
                    System.setProperty((String) key, properties.getProperty((String) key));
                }
            }

            // 添加系统属性
            Properties p = System.getProperties();
            Enumeration<Object> keys = p.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                String value = (String) p.get(key);
                properties.put(key, value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String[] getChildLocations() {
        return childLocations;
    }

    public void setChildLocations(String[] childLocations) {
        this.childLocations = childLocations;
        Resource[] resources = new Resource[childLocations.length + 1];
        for (int i = 0; i < childLocations.length; i++) {
            resources[i] = getResource(childLocations[i]);
        }
        resources[childLocations.length] = rootLocation;

        setLocations(resources); // 给父类
    }

    @SuppressWarnings("deprecation")
    private Resource getResource(String location) {
        location = parseStringValue(location, properties, new HashSet<String>());
        DefaultResourceLoader loader = new DefaultResourceLoader();
        return loader.getResource(location);
    }

    /**
     * 重写父类方法，解密指定属性名对应的属性值. 也可以通过重写convertPropertyValue方法，直接通过属性值来判断是否需要解密
     */
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptPropertyVal(propertyName)) {
            propertyValue = getDecryptString(propertyValue);
            System.out.println("encrypted need decrypt!!!");
        }
        return super.convertProperty(propertyName, propertyValue);
    }

    private String getDecryptString(String str) {
        return str;
    }

    /**
     * 判断属性值是否需要解密，这里约定需要解密的属性名用encrypt开头
     *
     * @param propertyName
     * @return
     */
    private boolean isEncryptPropertyVal(String propertyName) {
        return propertyName.startsWith("encrypt");
    }
}
