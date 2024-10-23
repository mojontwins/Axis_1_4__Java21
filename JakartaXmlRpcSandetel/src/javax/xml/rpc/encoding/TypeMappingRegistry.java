package javax.xml.rpc.encoding;

import java.io.*;

public interface TypeMappingRegistry extends Serializable
{
    TypeMapping register(final String p0, final TypeMapping p1);
    
    void registerDefault(final TypeMapping p0);
    
    TypeMapping getDefaultTypeMapping();
    
    String[] getRegisteredEncodingStyleURIs();
    
    TypeMapping getTypeMapping(final String p0);
    
    TypeMapping createTypeMapping();
    
    TypeMapping unregisterTypeMapping(final String p0);
    
    boolean removeTypeMapping(final TypeMapping p0);
    
    void clear();
}
