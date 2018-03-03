/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demos.misc1.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 *
 * @author kunpeng.wkp
 */
class DelLoginClassAdapter extends ClassAdapter { 
    public DelLoginClassAdapter(ClassVisitor cv) { 
        super(cv); 
    } 
 
    @Override
    public MethodVisitor visitMethod(final int access, final String name, 
        final String desc, final String signature, final String[] exceptions) { 
        if (name.equals("login")) { 
            return null; 
        } 
        return cv.visitMethod(access, name, desc, signature, exceptions); 
    } 
}
