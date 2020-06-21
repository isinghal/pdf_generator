package nut.doubt.service;

import nut.doubt.constant.Constance;
import nut.doubt.models.request.DoubtRequest;
import nut.doubt.util.PDFGenerator;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Service
public class DoubtServiceImpl implements DoubtService {

    private static Map<String, ScheduledFuture> executorMap = new HashMap<>();
    private static Map<String, List<String>> doubtListMap = new HashMap<>();
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    @Override
    public void handleRequest(DoubtRequest doubtRequest) {
        String userId = doubtRequest.getUserId();
        List<String> doubtList;
        if(executorMap.containsKey(userId)) {
            executorMap.get(userId).cancel(true);
            doubtList = doubtListMap.get(userId);
        } else {
            doubtList = new ArrayList<>();
            doubtListMap.put(userId, doubtList);
        }
        doubtList.add(doubtRequest.getDoubtString());

        executorMap.put(userId, executor.schedule(() -> {
            PDFGenerator.generatePDF(doubtListMap.get(userId), userId);
            executorMap.remove(userId);
            doubtList.remove(userId);
        }, Constance.IDLE_MINS_T0_SEND_REPORT, TimeUnit.MINUTES));
    }
}
