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
class GradlewBatGenerator implements Generator {

    void execute(Context context, ZipOutputStream zos) {

        String template = new ClassPathResource("generators/gradlew.bat.txt").inputStream.text

        ZipEntry zipEntry = new ZipEntry("gradlew.bat")
        zos.putNextEntry(zipEntry)
        zos << template
    }

}

