package com.olamagic

import com.olamagic.report.ReportMapper
import grails.converters.JSON

class ReportController {

    def generate() {
        def report = ReportMapper.resolve[params.type].generate()
        render ([reports: [[id: params.type, a: report]]] as JSON)
    }

}