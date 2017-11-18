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
class BuildGradleGenerator implements Generator {

    void execute(Context context, ZipOutputStream zos) {

        String template = new ClassPathResource("generators/build.gradle.txt").inputStream.text

        String content = template.replaceAll("<<group>>", context.get("group"))

        ZipEntry zipEntry = new ZipEntry("build.gradle")
        zos.putNextEntry(zipEntry)
        zos << content
    }


}
