package javax.xml.soap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings( {"removal" })
class FactoryFinder
{
    private static final Logger logger;
    private static final ServiceLoaderUtil.ExceptionHandler<SOAPException> EXCEPTION_HANDLER;
    @SuppressWarnings("unused")
	private static final String OSGI_SERVICE_LOADER_CLASS_NAME = "org.glassfish.hk2.osgiresourcelocator.ServiceLoader";
    
    @SuppressWarnings("unchecked")
	static <T> T find(final Class<T> factoryClass, final String defaultClassName, final boolean tryFallback, final String deprecatedFactoryId) throws SOAPException {
        ClassLoader tccl = null;
		try {
			tccl = ServiceLoaderUtil.contextClassLoader(FactoryFinder.EXCEPTION_HANDLER);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        final String factoryId = factoryClass.getName();
        String className = fromSystemProperty(factoryId, deprecatedFactoryId);
        if (className != null) {
            final Object result = newInstance(className, defaultClassName, tccl);
            if (result != null) {
                return (T)result;
            }
        }
        className = fromJDKProperties(factoryId, deprecatedFactoryId);
        if (className != null) {
            final Object result = newInstance(className, defaultClassName, tccl);
            if (result != null) {
                return (T)result;
            }
        }
        T factory = null;
		try {
			factory = ServiceLoaderUtil.firstByServiceLoader(factoryClass, FactoryFinder.logger, FactoryFinder.EXCEPTION_HANDLER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (factory != null) {
            return factory;
        }
        className = fromMetaInfServices(deprecatedFactoryId, tccl);
        if (className != null) {
            FactoryFinder.logger.log(Level.WARNING, "Using deprecated META-INF/services mechanism with non-standard property: {0}. Property {1} should be used instead.", new Object[] { deprecatedFactoryId, factoryId });
            final Object result2 = newInstance(className, defaultClassName, tccl);
            if (result2 != null) {
                return (T)result2;
            }
        }
        if (isOsgi()) {
            return (T)lookupUsingOSGiServiceLoader(factoryId);
        }
        if (!tryFallback) {
            return null;
        }
        if (defaultClassName == null) {
            throw new SOAPException("Provider for " + factoryId + " cannot be found", null);
        }
        return (T)newInstance(defaultClassName, defaultClassName, tccl);
    }
    
    static <T> T find(final Class<T> factoryClass, final String defaultClassName, final boolean tryFallback) throws SOAPException {
        return find(factoryClass, defaultClassName, tryFallback, null);
    }
    
    private static Object newInstance(final String className, final String defaultClassName, final ClassLoader tccl) throws SOAPException {
        try {
			return ServiceLoaderUtil.newInstance(className, defaultClassName, tccl, FactoryFinder.EXCEPTION_HANDLER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    private static String fromMetaInfServices(final String deprecatedFactoryId, final ClassLoader tccl) {
        final String serviceId = "META-INF/services/" + deprecatedFactoryId;
        FactoryFinder.logger.log(Level.FINE, "Checking deprecated {0} resource", serviceId);
        try {
            final InputStream is = (tccl == null) ? ClassLoader.getSystemResourceAsStream(serviceId) : tccl.getResourceAsStream(serviceId);
            try {
                if (is != null) {
                    final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                    String factoryClassName;
                    try {
                        final BufferedReader rd = new BufferedReader(isr);
                        try {
                            factoryClassName = rd.readLine();
                            rd.close();
                        }
                        catch (Throwable t) {
                            try {
                                rd.close();
                            }
                            catch (Throwable t2) {
                                t.addSuppressed(t2);
                            }
                            throw t;
                        }
                        isr.close();
                    }
                    catch (Throwable t3) {
                        try {
                            isr.close();
                        }
                        catch (Throwable t4) {
                            t3.addSuppressed(t4);
                        }
                        throw t3;
                    }
                    logFound(factoryClassName);
                    if (factoryClassName != null && !"".equals(factoryClassName)) {
                        final String s = factoryClassName;
                        if (is != null) {
                            is.close();
                        }
                        return s;
                    }
                }
                if (is != null) {
                    is.close();
                }
            }
            catch (Throwable t5) {
                if (is != null) {
                    try {
                        is.close();
                    }
                    catch (Throwable t6) {
                        t5.addSuppressed(t6);
                    }
                }
                throw t5;
            }
        }
        catch (IOException ex) {}
        return null;
    }
    
    private static String fromJDKProperties(final String factoryId, final String deprecatedFactoryId) {
        Path path = null;
        try {
            final String JAVA_HOME = getSystemProperty("java.home");
            path = Paths.get(JAVA_HOME, "conf", "jaxm.properties");
            FactoryFinder.logger.log(Level.FINE, "Checking configuration in {0}", path);
            if (!Files.exists(path, new LinkOption[0])) {
                path = Paths.get(JAVA_HOME, "lib", "jaxm.properties");
            }
            FactoryFinder.logger.log(Level.FINE, "Checking configuration in {0}", path);
            if (Files.exists(path, new LinkOption[0])) {
                final Properties props = new Properties();
                final InputStream inputStream = Files.newInputStream(path, new OpenOption[0]);
                try {
                    props.load(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                catch (Throwable t) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        }
                        catch (Throwable t2) {
                            t.addSuppressed(t2);
                        }
                    }
                    throw t;
                }
                FactoryFinder.logger.log(Level.FINE, "Checking property {0}", factoryId);
                String factoryClassName = props.getProperty(factoryId);
                logFound(factoryClassName);
                if (factoryClassName != null) {
                    return factoryClassName;
                }
                if (deprecatedFactoryId != null) {
                    FactoryFinder.logger.log(Level.FINE, "Checking deprecated property {0}", deprecatedFactoryId);
                    factoryClassName = props.getProperty(deprecatedFactoryId);
                    logFound(factoryClassName);
                    if (factoryClassName != null) {
                        FactoryFinder.logger.log(Level.WARNING, "Using non-standard property: {0}. Property {1} should be used instead.", new Object[] { deprecatedFactoryId, factoryId });
                        return factoryClassName;
                    }
                }
            }
        }
        catch (Exception ignored) {
            FactoryFinder.logger.log(Level.SEVERE, "Error reading SAAJ configuration from [" + path + "] file. Check it is accessible and has correct format.", ignored);
        }
        return null;
    }
    
    private static String fromSystemProperty(final String factoryId, final String deprecatedFactoryId) {
        String systemProp = getSystemProperty(factoryId);
        if (systemProp != null) {
            return systemProp;
        }
        if (deprecatedFactoryId != null) {
            systemProp = getSystemProperty(deprecatedFactoryId);
            if (systemProp != null) {
                FactoryFinder.logger.log(Level.WARNING, "Using non-standard property: {0}. Property {1} should be used instead.", new Object[] { deprecatedFactoryId, factoryId });
                return systemProp;
            }
        }
        return null;
    }
    
	private static String getSystemProperty(final String property) {
        FactoryFinder.logger.log(Level.FINE, "Checking system property {0}", property);
        @SuppressWarnings("deprecation")
		final String value = AccessController.doPrivileged((PrivilegedAction<String>)new PrivilegedAction<String>() {
            @Override
            public String run() {
                return System.getProperty(property);
            }
        });
        logFound(value);
        return value;
    }
    
    private static void logFound(final String value) {
        if (value != null) {
            FactoryFinder.logger.log(Level.FINE, "  found {0}", value);
        }
        else {
            FactoryFinder.logger.log(Level.FINE, "  not found");
        }
    }
    
    private static boolean isOsgi() {
        try {
            Class.forName("org.glassfish.hk2.osgiresourcelocator.ServiceLoader");
            return true;
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
    }
    
    private static Object lookupUsingOSGiServiceLoader(final String factoryId) {
        try {
            final Class<?> serviceClass = Class.forName(factoryId);
            final Class<?>[] args = (Class<?>[])new Class[] { serviceClass };
            final Class<?> target = Class.forName("org.glassfish.hk2.osgiresourcelocator.ServiceLoader");
            final Method m = target.getMethod("lookupProviderInstances", Class.class);
            final Iterator<?> iter = ((Iterable<?>)m.invoke(null, (Object[])args)).iterator();
            return iter.hasNext() ? iter.next() : null;
        }
        catch (Exception ignored) {
            return null;
        }
    }
    
    static {
        logger = Logger.getLogger("jakarta.xml.soap");
        EXCEPTION_HANDLER = new ServiceLoaderUtil.ExceptionHandler<SOAPException>() {
            @Override
            public SOAPException createException(final Throwable throwable, final String message) {
                return new SOAPException(message, throwable);
            }
        };
    }
}
