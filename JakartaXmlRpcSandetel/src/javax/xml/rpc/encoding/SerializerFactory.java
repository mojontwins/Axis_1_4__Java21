package javax.xml.rpc.encoding;

import java.io.*;
import java.util.*;

public interface SerializerFactory extends Serializable
{
    Serializer getSerializerAs(final String p0);
    
    Iterator<?> getSupportedMechanismTypes();
}
