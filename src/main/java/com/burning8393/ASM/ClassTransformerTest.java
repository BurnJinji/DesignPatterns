package com.burning8393.ASM;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformerTest {
    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader(ClassPrinter.class.getClassLoader().getResourceAsStream("com/burning8393/ASM//Tank.class"));

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/burning8393/ASM/TimeProxy", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray();

        MyClassLoader cl = new MyClassLoader();
        cl.loadClass("com.burning8393.ASM.Tank");
        Class c2 = cl.defineClass("com.burning8393.ASM.Tank", b2);
        c2.getConstructor().newInstance();

        String path = (String) System.getProperties().get("user.dir");
        File f = new File(path + "/com/burning8393/ASM/");
        f.mkdir();

        FileOutputStream fos = new FileOutputStream(new File(path + "/target/classes/com/burning8393/ASM/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();
    }
}
