package com.magda.bon.kociaki.configuration;

import org.springframework.context.annotation.Import;

/**
 * @author kba
 */
@Import({ContextConfiguration.class, SwaggerConfiguration.class, WebMvcConfiguration.class})
public class KociakiConfiguration {
}
