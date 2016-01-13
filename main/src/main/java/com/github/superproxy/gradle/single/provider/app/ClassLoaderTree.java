package com.github.superproxy.gradle.single.provider.app;

public class ClassLoaderTree {
//    https://www.ibm.com/developerworks/cn/java/j-lo-classloader/
    public static void main(String[] args) { 
        ClassLoader loader = ClassLoaderTree.class.getClassLoader(); 
        while (loader != null) { 
            System.out.println(loader.toString()); 
            loader = loader.getParent(); 
        } 
    } 
 }