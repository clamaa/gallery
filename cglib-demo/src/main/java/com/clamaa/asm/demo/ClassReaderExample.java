package com.clamaa.asm.demo;

import org.objectweb.asm.*;

import java.io.IOException;

/**
 * User: mazhqa
 * Date: 14-3-7
 */
public class ClassReaderExample {

    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("java.lang.String");
        classReader.accept(new MyClassVisitor(Opcodes.ASM4), ClassReader.EXPAND_FRAMES);
    }

    private static class MyClassVisitor extends ClassVisitor {

        public MyClassVisitor(int api) {
            super(api);
        }

        @Override
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            System.out.println(String.format("class version : %s, access : %s, signature: %s, superName: %s, interfaces :%s", version, access, name, signature, superName, interfaces));
        }

        @Override
        public void visitSource(String source, String debug) {
            super.visitSource(source, debug);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void visitOuterClass(String owner, String name, String desc) {
            super.visitOuterClass(owner, name, desc);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return super.visitAnnotation(desc, visible);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void visitAttribute(Attribute attr) {
            super.visitAttribute(attr);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void visitInnerClass(String name, String outerName, String innerName, int access) {
            super.visitInnerClass(name, outerName, innerName, access);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
            return super.visitField(access, name, desc, signature, value);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            return super.visitMethod(access, name, desc, signature, exceptions);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void visitEnd() {
            super.visitEnd();    //To change body of overridden methods use File | Settings | File Templates.
        }
    }

}
