package org.profamilia.registro.web;
import java.io.Serializable;
import java.util.Date;
 
public class Event implements Serializable {
 
    private String name;
    private Date start;
    private Date end;
 
    public Event(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Date getStart() {
        return start;
    }
 
    public void setStart(Date start) {
        this.start = start;
    }
 
    public Date getEnd() {
        return end;
    }
 
    public void setEnd(Date end) {
        this.end = end;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
 
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
 
        Event event = (Event) o;
 
        if (name != null ? !name.equals(event.name) : event.name != null) {
            return false;
        }
 
        return true;
    }
 
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}