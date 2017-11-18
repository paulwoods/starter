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
class GradleWrapperGenerator implements Generator {

    void execute(Context context, ZipOutputStream zos) {

        ZipEntry zipEntry = new ZipEntry("gradle/wrapper/gradle-wrapper.jar")
        zos.putNextEntry(zipEntry)
        zos << new ClassPathResource("generators/gradle-wrapper.jar").inputStream.bytes

        zipEntry = new ZipEntry("gradle/wrapper/gradle-wrapper.properties")
        zos.putNextEntry(zipEntry)
        zos << new ClassPathResource("generators/gradle-wrapper.properties").inputStream.bytes
    }

}
