package org.mrpaulwoods.starter.home

import org.mrpaulwoods.starter.action.CreateDownloadAction
import spock.lang.Specification

import javax.servlet.ServletOutputStream
import javax.servlet.http.HttpServletResponse

class HomeControllerSpec extends Specification {
    CreateDownloadAction createDownloadAction = Mock(CreateDownloadAction)

    HomeController controller = new HomeController(createDownloadAction)

    def "index returns the home/index view"() {
        when:
        def view = controller.index()

        then:
        view == "home/index"
    }

    def "download calls the action and returns the zip file"() {

        HttpServletResponse response = Mock(HttpServletResponse)
        ServletOutputStream sos = Mock(ServletOutputStream)

        when:
        controller.download(response)

        then:
        1 * response.setContentType("application/zip")
        1 * response.getOutputStream() >> sos
        1 * createDownloadAction.execute(sos)
    }

}
