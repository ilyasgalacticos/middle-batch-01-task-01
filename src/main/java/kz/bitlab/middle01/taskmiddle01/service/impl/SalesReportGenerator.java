package kz.bitlab.middle01.taskmiddle01.service.impl;

import kz.bitlab.middle01.taskmiddle01.service.ReportGenerator;
import org.springframework.stereotype.Service;

@Service
public class SalesReportGenerator implements ReportGenerator {

    @Override
    public String type() {
        return "sales";
    }

    @Override
    public String generateReport() {
        return "I am generating sales report";
    }

}
