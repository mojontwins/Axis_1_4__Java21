package javax.xml.rpc.holders;

import javax.xml.namespace.*;

public final class QNameHolder implements Holder
{
    public QName value;
    
    public QNameHolder() {
    }
    
    public QNameHolder(final QName myQName) {
        this.value = myQName;
    }
}
