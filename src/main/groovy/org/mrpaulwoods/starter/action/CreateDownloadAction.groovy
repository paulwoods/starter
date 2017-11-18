package org.mrpaulwoods.starter.action

import groovy.util.logging.Slf4j
import org.mrpaulwoods.starter.generator.Context
import org.mrpaulwoods.starter.generator.Generator
import org.springframework.stereotype.Service

import java.util.zip.ZipOutputStream

@Slf4j
@Service
class CreateDownloadAction {

    final List<Generator> generators

    CreateDownloadAction(
            List<Generator> generators
    ) {
        this.generators = generators
    }

    void execute(OutputStream os) {

        Context context = new Context()
        context.put "group", "org.a.b.c"
        context.put "appname", "Basic"
        context.put "package", "org.mrpaulwoods.basic"
        ZipOutputStream zos = new ZipOutputStream(os)

        generators.each { it.execute context, zos }

        zos.close()

    }

}
