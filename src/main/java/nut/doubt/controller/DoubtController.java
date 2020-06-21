package nut.doubt.controller;

import nut.doubt.models.auxilary.BaseResponse;
import nut.doubt.models.request.DoubtRequest;
import nut.doubt.constant.Constance;
import nut.doubt.service.DoubtService;
import nut.doubt.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/submitDoubt")
public class DoubtController {

    @Autowired
    private DoubtService doubtService;

    @PostMapping("")
    public BaseResponse<String> submitDoubt(@RequestBody DoubtRequest doubtRequest) {
        doubtService.handleRequest(doubtRequest);
        return new BaseResponse<>(Constance.SUCCESS_DOUBT_SUBMITTED);
    }


}
