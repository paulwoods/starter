package org.mrpaulwoods.starter.action

import org.mrpaulwoods.starter.generator.Context
import org.mrpaulwoods.starter.generator.Generator
import spock.lang.Specification

import java.util.zip.ZipOutputStream


class CreateDownloadActionSpec extends Specification {

    Generator generator1 = Mock(Generator)
    CreateDownloadAction action = new CreateDownloadAction([generator1])

    def "execute sets the context, creates the zip and calls the generators"() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream()

        when:
        action.execute baos

        then:
        1 * generator1.execute(_, _) >> { Context c, ZipOutputStream z ->
            assert c.get("group") == "org.a.b.c"
            assert c.get("appname") == "Basic"
            assert c.get("package") == "org.mrpaulwoods.basic"
        }
    }
}
