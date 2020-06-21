package nut.doubt.controller;

import nut.doubt.constant.Constants;
import nut.doubt.models.auxilary.BaseResponse;
import nut.doubt.models.request.DoubtRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submitDoubt")
public class DoubtController {

    @PostMapping("")
    public BaseResponse<String> submitDoubt(@RequestBody DoubtRequest doubtRequest) {
        return new BaseResponse<>(Constants.SUCCESS_DOUBT_SUBMITTED);
    }


}
