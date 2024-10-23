package javax.xml.soap;

import java.util.Iterator;

import javax.xml.transform.Source;

import org.w3c.dom.Document;

public abstract class SOAPPart implements Document, Node
{
    public abstract SOAPEnvelope getEnvelope() throws SOAPException;
    
    public String getContentId() {
        final String[] values = this.getMimeHeader("Content-Id");
        if (values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }
    
    public String getContentLocation() {
        final String[] values = this.getMimeHeader("Content-Location");
        if (values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }
    
    public void setContentId(final String contentId) {
        this.setMimeHeader("Content-Id", contentId);
    }
    
    public void setContentLocation(final String contentLocation) {
        this.setMimeHeader("Content-Location", contentLocation);
    }
    
    public abstract void removeMimeHeader(final String p0);
    
    public abstract void removeAllMimeHeaders();
    
    public abstract String[] getMimeHeader(final String p0);
    
    public abstract void setMimeHeader(final String p0, final String p1);
    
    public abstract void addMimeHeader(final String p0, final String p1);
    
    public abstract Iterator<MimeHeader> getAllMimeHeaders();
    
    public abstract Iterator<MimeHeader> getMatchingMimeHeaders(final String[] p0);
    
    public abstract Iterator<MimeHeader> getNonMatchingMimeHeaders(final String[] p0);
    
    public abstract void setContent(final Source p0) throws SOAPException;
    
    public abstract Source getContent() throws SOAPException;
}
