package org.mrpaulwoods.starter.template

import groovy.util.logging.Slf4j
import org.mrpaulwoods.starter.generator.Context
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

@Slf4j
@Service
class TemplateService {

    String fill(Context context, String name) {
        String content = new ClassPathResource(name).inputStream.text
        context.each { String k, String v ->
            content = content.replaceAll("<<" + k + ">>", v)
        }
        content
    }

}
