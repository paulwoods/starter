package org.mrpaulwoods.starter.generator

import groovy.transform.Canonical

@Canonical
class Context {

    private Map<String, String> data = [:]

    void put(String key, String value) {
        data[key] = value
    }

    String get(String key) {
        data[key]
    }

    void each(Closure closure) {
        data.each closure
    }

    Context copy() {
        Context c = new Context()
        data.each { k, v ->
            c.put k, v
        }
        c
    }

    int size() {
        data.size()
    }

}
