package com.magda.bon.kociaki.gra;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Magda on 24.04.2017.
 */
@Component
public class RuchPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher ruchPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher ruchPublisher) {
        this.ruchPublisher = ruchPublisher;
    }

    public void publishOrderWykonanyRuch(PlanszaRuchWrapper planszaRuchWrapper) {
        ruchPublisher.publishEvent(new RuchEvent(this, planszaRuchWrapper));
    }


}
