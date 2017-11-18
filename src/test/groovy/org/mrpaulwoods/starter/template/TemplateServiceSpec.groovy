package org.mrpaulwoods.starter.template

import org.mrpaulwoods.starter.generator.Context
import spock.lang.Specification

class TemplateServiceSpec extends Specification {

    TemplateService service = new TemplateService()

    def "fill loads template, fills the tags and returns the content"() {

        Context context = new Context()
        context.put "package", "a.b.c"

        when:
        def content = service.fill(context, "generators/home.controller.txt")

        then:
        content.contains "package a.b.c"
        content.contains "class HomeController"
    }
}
