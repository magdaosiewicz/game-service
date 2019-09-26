package com.magda.bon.kociaki.gra;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Magda on 24.04.2017.
 */
public class RuchEvent extends ApplicationEvent {

    @Getter
    PlanszaRuchWrapper planszaRuchWrapper;


    public RuchEvent(Object source, PlanszaRuchWrapper planszaRuchWrapper) {
        super(source);
        this.planszaRuchWrapper = planszaRuchWrapper;
    }

}
