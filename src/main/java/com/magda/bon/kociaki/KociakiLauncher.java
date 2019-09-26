package com.magda.bon.kociaki;

import com.magda.bon.kociaki.configuration.KociakiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

/**
 * @author kba
 */
@Import(KociakiConfiguration.class)
public class KociakiLauncher {

    public static void main(String args[]) {
        SpringApplication.run(KociakiLauncher.class, args);
    }

}

