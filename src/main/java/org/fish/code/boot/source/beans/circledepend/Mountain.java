package org.fish.code.boot.source.beans.circledepend;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Mountain {
    private Monk monk;
    
    public Mountain() {}
    
    public Mountain(Monk monk) {
    	this.monk = monk;
    }
}
