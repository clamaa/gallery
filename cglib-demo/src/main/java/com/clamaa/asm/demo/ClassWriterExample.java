package com.clamaa.asm.demo;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 * User: mazhqa
 * Date: 14-3-7
 */
public class ClassWriterExample {

    public static class Foo{
        public void execute(){
            System.out.println("Hello world");
        }
    }

    public static void main(String[] args) throws IOException {
        Foo foo = new Foo();
        foo.execute();
        ClassReader classReader = new ClassReader(foo.getClass().getName());
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//        classReader.accept(new ClassVisitor(){
//
//        });

    }

}
