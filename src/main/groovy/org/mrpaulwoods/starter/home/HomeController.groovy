package org.mrpaulwoods.starter.home

import groovy.util.logging.Slf4j
import org.mrpaulwoods.starter.action.CreateDownloadAction
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletResponse

@Slf4j
@Controller
@RequestMapping
class HomeController {

    private CreateDownloadAction createDownloadAction

    HomeController(CreateDownloadAction createDownloadAction) {
        this.createDownloadAction = createDownloadAction
    }

    @GetMapping
    String index() {
        "home/index"
    }

    @PostMapping("/download")
    void download(HttpServletResponse response) {
        response.contentType = "application/zip"
        createDownloadAction.execute response.outputStream
    }

}
