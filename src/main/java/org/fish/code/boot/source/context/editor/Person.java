package org.fish.code.boot.source.context.editor;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * Birthday, age, sex, etc.
 * 
 * @author chenjunfeng1
 *
 */
@Data
@ToString
public class Person {
    private Date birthDate;
    private int age;
    private int sex;
}
