package org.mrpaulwoods.starter.path

import groovy.util.logging.Slf4j
import org.mrpaulwoods.starter.generator.Context
import org.springframework.stereotype.Service

@Slf4j
@Service
class PathService {

    String basePackage(Context context) {
        context.get("package").replace(".", File.separator)
    }

    List<String> basePackageAsList(Context context) {
        context.get("package").split("\\.") as List
    }

    String source(Context context, String name) {
        source context, [name]
    }

    String source(Context context, List<String> suffixes) {
        List<String> names = ['src', 'main', 'groovy']
        names += basePackageAsList(context)
        names += suffixes
        names.join(File.separator)
    }

}
