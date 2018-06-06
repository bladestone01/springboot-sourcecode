package org.fish.code.boot.source.context.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatePropertyEditor extends PropertyEditorSupport {
    private String format = "yyyy-MM-dd";
    
    public void setFormat(String format) {
    	this.format = format;
    }
    
    @Override
    public void setAsText(String text) throws java.lang.IllegalArgumentException {
    	log.debug("date editor:{}", text);
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    	
    	LocalDate date = LocalDate.parse(text, formatter);
        Date newDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        
        this.setValue(newDate);
    }
}
