package org.mrpaulwoods.starter.generators

import org.mrpaulwoods.starter.generator.Context
import org.mrpaulwoods.starter.generator.Generator
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

@Service
class GitIgnoreGenerator implements Generator {

    void execute(Context context, ZipOutputStream zos) {

        String template = new ClassPathResource("generators/gitignore.txt").inputStream.text

        ZipEntry zipEntry = new ZipEntry(".gitignore")
        zos.putNextEntry(zipEntry)
        zos << template
    }

}
