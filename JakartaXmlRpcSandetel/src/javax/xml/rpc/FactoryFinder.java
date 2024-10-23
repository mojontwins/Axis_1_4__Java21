package javax.xml.rpc;

import java.util.*;
import java.io.*;

class FactoryFinder
{
    @SuppressWarnings("deprecation")
	private static Object newInstance(final String className, final ClassLoader classLoader) throws ServiceException {
        try {
            Class<?> spiClass;
            if (classLoader == null) {
                spiClass = Class.forName(className);
            }
            else {
                spiClass = classLoader.loadClass(className);
            }
            return spiClass.newInstance();
        }
        catch (ClassNotFoundException x) {
            throw new ServiceException("Provider " + className + " not found", x);
        }
        catch (Exception x2) {
            throw new ServiceException("Provider " + className + " could not be instantiated: " + x2, x2);
        }
    }
    
    static Object find(final String factoryId, final String fallbackClassName) throws ServiceException {
        ClassLoader classLoader;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        catch (Exception x) {
            throw new ServiceException(x.toString(), x);
        }
        try {
            final String systemProp = System.getProperty(factoryId);
            if (systemProp != null) {
                return newInstance(systemProp, classLoader);
            }
        }
        catch (SecurityException ex) {}
        try {
            final String javah = System.getProperty("java.home");
            final String configFile = javah + File.separator + "lib" + File.separator + "jaxrpc.properties";
            final File f = new File(configFile);
            if (f.exists()) {
                final Properties props = new Properties();
                props.load(new FileInputStream(f));
                final String factoryClassName = props.getProperty(factoryId);
                return newInstance(factoryClassName, classLoader);
            }
        }
        catch (Exception ex2) {}
        final String serviceId = "META-INF/services/" + factoryId;
        try {
            InputStream is = null;
            if (classLoader == null) {
                is = ClassLoader.getSystemResourceAsStream(serviceId);
            }
            else {
                is = classLoader.getResourceAsStream(serviceId);
            }
            if (is != null) {
                final BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                final String factoryClassName2 = rd.readLine();
                rd.close();
                if (factoryClassName2 != null && !"".equals(factoryClassName2)) {
                    return newInstance(factoryClassName2, classLoader);
                }
            }
        }
        catch (Exception ex3) {}
        if (fallbackClassName == null) {
            throw new ServiceException("Provider for " + factoryId + " cannot be found", null);
        }
        return newInstance(fallbackClassName, classLoader);
    }
}
