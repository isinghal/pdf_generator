package nut.doubt.service;

import nut.doubt.models.request.DoubtRequest;


public interface DoubtService {
    void handleRequest(DoubtRequest doubtRequest);
}
