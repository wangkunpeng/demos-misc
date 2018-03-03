/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demos.misc1.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 *
 * @author kunpeng.wkp
 */
public class AccessClassAdapter  extends ClassAdapter { 
    public AccessClassAdapter(ClassVisitor cv) { 
        super(cv); 
    } 
 
    @Override
    public FieldVisitor visitField(final int access, final String name, 
       final String desc, final String signature, final Object value) { 
       int privateAccess = Opcodes.ACC_PRIVATE; 
       return cv.visitField(privateAccess, name, desc, signature, value); 
   } 
}