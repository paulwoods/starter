package org.mrpaulwoods.starter.generators

import groovy.util.logging.Slf4j
import org.mrpaulwoods.starter.generator.Context
import org.mrpaulwoods.starter.generator.Generator
import org.mrpaulwoods.starter.path.PathService
import org.mrpaulwoods.starter.template.TemplateService
import org.springframework.stereotype.Service

import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

@Slf4j
@Service
class ServletInitializerGenerator implements Generator {

    private TemplateService templateService
    private PathService pathService

    ServletInitializerGenerator(
            TemplateService templateService,
            PathService pathService
    ) {
        this.templateService = templateService
        this.pathService = pathService
    }

    void execute(Context context, ZipOutputStream zos) {
        String content = templateService.fill(context, "generators/servlet-initializer.txt")
        String name = pathService.source(context, "ServletInitializer.groovy")

        ZipEntry zipEntry = new ZipEntry(name)
        zos.putNextEntry(zipEntry)
        zos << content
    }

}
