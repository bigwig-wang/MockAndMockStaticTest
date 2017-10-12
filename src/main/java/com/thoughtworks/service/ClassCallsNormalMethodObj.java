package com.thoughtworks.service;

/**
 * Created by dhwang on 12/10/2017.
 */
public class ClassCallsNormalMethodObj {
    private Nomarl nomarl;

    public ClassCallsNormalMethodObj(Nomarl nomarl) {
        this.nomarl = nomarl;
    }



    public String excute() {
        String s = nomarl.firstNormalMethod();
        String s1 = nomarl.secondNOrmalMethod();
        return s + s1;

    }
}
