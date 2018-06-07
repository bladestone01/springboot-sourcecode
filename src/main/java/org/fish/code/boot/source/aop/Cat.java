package org.fish.code.boot.source.aop;

import lombok.Data;

@Data
public class Cat {
    private String sound = "MiaoMiao....";
    
    public String voice() {
    	return this.sound;
    }
}
