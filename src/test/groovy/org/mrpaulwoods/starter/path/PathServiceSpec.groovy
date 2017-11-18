package org.mrpaulwoods.starter.path

import org.mrpaulwoods.starter.generator.Context
import spock.lang.Specification

class PathServiceSpec extends Specification {

    PathService service = new PathService()

    Context context = new Context()

    def "basePackage returns the package as a path"() {
        context.put "package", "a.b.c"

        expect:
        service.basePackage(context) == "a\\b\\c"
    }

    def "source (string) returns the source folder plus package as a path plus the name"() {
        context.put "package", "a.b.c"

        expect:
        service.source(context, "alpha") == "src\\main\\groovy\\a\\b\\c\\alpha"
    }

    def "source (list) returns the source folder plus package as a path plus the name"() {
        context.put "package", "a.b.c"

        expect:
        service.source(context, ["alpha"]) == "src\\main\\groovy\\a\\b\\c\\alpha"
    }
}
