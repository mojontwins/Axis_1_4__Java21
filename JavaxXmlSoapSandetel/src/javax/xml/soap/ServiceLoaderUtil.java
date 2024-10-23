package javax.xml.soap;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServiceLoaderUtil
{
    static <P, T extends Exception> P firstByServiceLoader(final Class<P> spiClass, final Logger logger, final ExceptionHandler<T> handler) throws T, Exception {
        logger.log(Level.FINE, "Using java.util.ServiceLoader to find {0}", spiClass.getName());
        try {
            final ServiceLoader<P> serviceLoader = ServiceLoader.load(spiClass);
            final Iterator<P> iterator = serviceLoader.iterator();
            if (iterator.hasNext()) {
                final P impl = iterator.next();
                logger.log(Level.FINE, "ServiceProvider loading Facility used; returning object [{0}]", impl.getClass().getName());
                return impl;
            }
        }
        catch (Throwable t) {
            throw handler.createException(t, "Error while searching for service [" + spiClass.getName() + "]");
        }
        return null;
    }
    
    @SuppressWarnings({ "deprecation", "removal" })
	static void checkPackageAccess(final String className) {
        @SuppressWarnings("removal")
		final SecurityManager s = System.getSecurityManager();
        if (s != null) {
            final int i = className.lastIndexOf(46);
            if (i != -1) {
                s.checkPackageAccess(className.substring(0, i));
            }
        }
    }
    
    static Class<?> nullSafeLoadClass(final String className, final ClassLoader classLoader) throws ClassNotFoundException {
        if (classLoader == null) {
            return Class.forName(className);
        }
        return classLoader.loadClass(className);
    }
    
    @SuppressWarnings("deprecation")
	static <T extends Exception> Object newInstance(final String className, final String defaultImplClassName, final ClassLoader classLoader, final ExceptionHandler<T> handler) throws T, Exception {
        try {
            return safeLoadClass(className, defaultImplClassName, classLoader).newInstance();
        }
        catch (ClassNotFoundException x) {
            throw handler.createException(x, "Provider " + className + " not found");
        }
        catch (Exception x2) {
            throw handler.createException(x2, "Provider " + className + " could not be instantiated: " + x2);
        }
    }
    
    static Class<?> safeLoadClass(final String className, final String defaultImplClassName, final ClassLoader classLoader) throws ClassNotFoundException {
        try {
            checkPackageAccess(className);
        }
        catch (SecurityException se) {
            if (defaultImplClassName != null && defaultImplClassName.equals(className)) {
                return Class.forName(className);
            }
            throw se;
        }
        return nullSafeLoadClass(className, classLoader);
    }
    
    static <T extends Exception> ClassLoader contextClassLoader(final ExceptionHandler<T> exceptionHandler) throws T, Exception {
        try {
            return Thread.currentThread().getContextClassLoader();
        }
        catch (Exception x) {
            throw exceptionHandler.createException(x, x.toString());
        }
    }
    
    abstract static class ExceptionHandler<T extends Exception>
    {
        public abstract T createException(final Throwable p0, final String p1);
    }
}
