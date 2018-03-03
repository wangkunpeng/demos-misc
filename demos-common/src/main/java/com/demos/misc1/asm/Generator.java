/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demos.misc1.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

/**
 *
 * @author kunpeng.wkp
 */
public class Generator {

    public static void main() throws Exception {
        ClassReader cr = new ClassReader("Account");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        //cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        //byte[] data = cw.toByteArray();
        //File file = new File("Account.class");
        //FileOutputStream fout = new FileOutputStream(file);
        //fout.write(data);
        //fout.close();
    }
}
