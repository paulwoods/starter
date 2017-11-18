package org.mrpaulwoods.starter.generator

import spock.lang.Specification

class ContextSpec extends Specification {
    Context context = new Context()

    def "initial context has no entries"() {
        expect:
        context.size() == 0
    }

    def "adding entries increases size"() {
        context.put "a", "1"
        context.put "b", "2"
        context.put "c", "3"

        expect:
        context.size() == 3
    }

    def "values can be retrieved"() {
        context.put "a", "1"
        context.put "b", "2"
        context.put "c", "3"

        expect:
        context.get("a") == "1"
        context.get("b") == "2"
        context.get("c") == "3"
    }

    def "missing keys return null"() {

        expect:
        context.get("xyz") == null
    }

    def "each loops over the items"() {
        def map = [:]
        context.put "a", "1"
        context.put "b", "2"

        when:
        context.each { k, v -> map.put(k, v) }

        then:
        map == ["a": "1", "b": "2"]
    }

    def "copy copies the values"() {
        context.put "a", "1"
        context.put "b", "2"

        when:
        Context context2 = context.copy()
        context.put "a", "11111"
        context.put "b", "22222"

        then:
        context.get("a") == "11111"
        context.get("b") == "22222"

        and:
        context2.get("a") == "1"
        context2.get("b") == "2"
    }
}
