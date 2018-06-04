package org.fish.code.boot.source.beans.circledepend;

import lombok.Data;

@Data
public class Temple {
    private Mountain mountain;
    
    public Temple() {}
    
    public Temple(Mountain mountain) {
    	this.mountain = mountain;
    }
}
