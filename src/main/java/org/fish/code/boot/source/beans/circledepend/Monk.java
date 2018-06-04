package org.fish.code.boot.source.beans.circledepend;

import lombok.Data;

@Data
public class Monk {
     private Temple temple;
     
     public Monk() {}
     
     public Monk(Temple temple) {
    	 this.temple = temple;
     }
}
