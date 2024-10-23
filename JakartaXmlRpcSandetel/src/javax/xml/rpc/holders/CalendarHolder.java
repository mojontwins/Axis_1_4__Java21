package javax.xml.rpc.holders;

import java.util.*;

public final class CalendarHolder implements Holder
{
    public Calendar value;
    
    public CalendarHolder() {
    }
    
    public CalendarHolder(final Calendar myCalendar) {
        this.value = myCalendar;
    }
}
