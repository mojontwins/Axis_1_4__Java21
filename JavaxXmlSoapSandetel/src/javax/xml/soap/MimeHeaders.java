package javax.xml.soap;

import java.util.Iterator;
import java.util.Vector;

public class MimeHeaders
{
    private Vector<MimeHeader> headers;
    
    public MimeHeaders() {
        this.headers = new Vector<MimeHeader>();
    }
    
    public String[] getHeader(final String name) {
        final Vector<String> values = new Vector<String>();
        for (int i = 0; i < this.headers.size(); ++i) {
            final MimeHeader hdr = this.headers.elementAt(i);
            if (hdr.getName().equalsIgnoreCase(name) && hdr.getValue() != null) {
                values.addElement(hdr.getValue());
            }
        }
        if (values.size() == 0) {
            return null;
        }
        final String[] r = new String[values.size()];
        values.copyInto(r);
        return r;
    }
    
    public void setHeader(final String name, final String value) {
        boolean found = false;
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Illegal MimeHeader name");
        }
        for (int i = 0; i < this.headers.size(); ++i) {
            final MimeHeader hdr = this.headers.elementAt(i);
            if (hdr.getName().equalsIgnoreCase(name)) {
                if (!found) {
                    this.headers.setElementAt(new MimeHeader(hdr.getName(), value), i);
                    found = true;
                }
                else {
                    this.headers.removeElementAt(i--);
                }
            }
        }
        if (!found) {
            this.addHeader(name, value);
        }
    }
    
    public void addHeader(final String name, final String value) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Illegal MimeHeader name");
        }
        final int pos = this.headers.size();
        for (int i = pos - 1; i >= 0; --i) {
            final MimeHeader hdr = this.headers.elementAt(i);
            if (hdr.getName().equalsIgnoreCase(name)) {
                this.headers.insertElementAt(new MimeHeader(name, value), i + 1);
                return;
            }
        }
        this.headers.addElement(new MimeHeader(name, value));
    }
    
    public void removeHeader(final String name) {
        for (int i = 0; i < this.headers.size(); ++i) {
            final MimeHeader hdr = this.headers.elementAt(i);
            if (hdr.getName().equalsIgnoreCase(name)) {
                this.headers.removeElementAt(i--);
            }
        }
    }
    
    public void removeAllHeaders() {
        this.headers.removeAllElements();
    }
    
    public Iterator<MimeHeader> getAllHeaders() {
        return this.headers.iterator();
    }
    
    public Iterator<MimeHeader> getMatchingHeaders(final String[] names) {
        return new MatchingIterator(names, true, this.headers.iterator());
    }
    
    public Iterator<MimeHeader> getNonMatchingHeaders(final String[] names) {
        return new MatchingIterator(names, false, this.headers.iterator());
    }
    
    static class MatchingIterator implements Iterator<MimeHeader>
    {
        private final boolean match;
        private final Iterator<MimeHeader> iterator;
        private final String[] names;
        private MimeHeader nextHeader;
        
        MatchingIterator(final String[] names, final boolean match, final Iterator<MimeHeader> i) {
            this.match = match;
            this.names = names;
            this.iterator = i;
        }
        
        private MimeHeader nextMatch() {
        Label_0000:
            while (this.iterator.hasNext()) {
                final MimeHeader hdr = this.iterator.next();
                if (this.names == null) {
                    return this.match ? null : hdr;
                }
                int i = 0;
                while (i < this.names.length) {
                    if (hdr.getName().equalsIgnoreCase(this.names[i])) {
                        if (this.match) {
                            return hdr;
                        }
                        continue Label_0000;
                    }
                    else {
                        ++i;
                    }
                }
                if (!this.match) {
                    return hdr;
                }
            }
            return null;
        }
        
        @Override
        public boolean hasNext() {
            if (this.nextHeader == null) {
                this.nextHeader = this.nextMatch();
            }
            return this.nextHeader != null;
        }
        
        @Override
        public MimeHeader next() {
            if (this.nextHeader != null) {
                final MimeHeader ret = this.nextHeader;
                this.nextHeader = null;
                return ret;
            }
            if (this.hasNext()) {
                return this.nextHeader;
            }
            return null;
        }
        
        @Override
        public void remove() {
            this.iterator.remove();
        }
    }
}
