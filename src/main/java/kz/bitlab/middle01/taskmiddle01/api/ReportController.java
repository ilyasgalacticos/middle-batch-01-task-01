package kz.bitlab.middle01.taskmiddle01.api;

import kz.bitlab.middle01.taskmiddle01.service.ReportGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/generate-report")
public class ReportController {

    private final Map<String, ReportGenerator> reportGenerators;

    @Autowired
    public ReportController(List<ReportGenerator> reportGenerators){
        this.reportGenerators = reportGenerators.stream()
                .collect(Collectors.toMap(ReportGenerator::type, Function.identity()));
    }

    @GetMapping("{type}")
    public String generate(@PathVariable(name = "type") String type){
        ReportGenerator reportGenerator = reportGenerators.get(type);
        if(reportGenerator==null){
            return "Invalid type";
        }
        return reportGenerator.generateReport();
    }
}