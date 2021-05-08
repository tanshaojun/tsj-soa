package com.other.cls.Instrument;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @Author tansj
 * @Date 2021-05-08 13:40
 * @Version 1.0
 */
public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("35590");
        vm.loadAgent("/Users/tanshaojun/project/tsj-soa/springboot/target/springboot-1.0-SNAPSHOT.jar");
    }
}
