package org.mrpaulwoods.starter.generators

import groovy.util.logging.Slf4j
import org.mrpaulwoods.starter.generator.Context
import org.mrpaulwoods.starter.generator.Generator
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

@Slf4j
@Service
class ApplicationPropertiesGenerator implements Generator {

    void execute(Context context, ZipOutputStream zos) {

        String content = new ClassPathResource("generators/application.properties.txt").inputStream.text

        ZipEntry zipEntry = new ZipEntry("src/main/resources/application.properties")
        zos.putNextEntry(zipEntry)
        zos << content
    }


}
