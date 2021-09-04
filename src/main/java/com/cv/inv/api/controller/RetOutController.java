/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.controller;

import com.cv.inv.api.common.FilterObject;
import com.cv.inv.api.common.ReturnObject;
import com.cv.inv.api.common.Util1;
import com.cv.inv.api.entity.RetOutHis;
import com.cv.inv.api.entity.RetOutHisDetail;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cv.inv.api.service.RetOutDetailService;
import com.cv.inv.api.service.RetOutService;

/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/retout")
@Slf4j
public class RetOutController {

    @Autowired
    private RetOutService roService;
    @Autowired
    private RetOutDetailService rdService;
    private final ReturnObject ro = new ReturnObject();

    @PostMapping(path = "/save-retout")
    public ResponseEntity<RetOutHis> saveRO(@RequestBody RetOutHis retout, HttpServletRequest request) throws Exception {
        log.info("/save-retout");
        retout = roService.save(retout);
        return ResponseEntity.ok(retout);
    }

    @PostMapping(path = "/get-retout")
    public ResponseEntity<List<RetOutHis>> getRO(@RequestBody FilterObject filter) {
        log.info("/get-retout");
        String fromDate = Util1.isNull(filter.getFromDate(), "-");
        String toDate = Util1.isNull(filter.getToDate(), "-");
        String vouNo = Util1.isNull(filter.getVouNo(), "-");
        String userCode = Util1.isNull(filter.getUserCode(), "-");
        String cusCode = Util1.isNull(filter.getCusCode(), "-");
        List<RetOutHis> listRO = roService.search(fromDate, toDate, cusCode, vouNo, userCode);
        return ResponseEntity.ok(listRO);
    }

    @DeleteMapping(path = "/delete-retout")
    public ResponseEntity<ReturnObject> deleteRO(@RequestParam String code) throws Exception {
        log.info("/delete-retout");
        roService.delete(code);
        ro.setMessage("Deleted.");
        return ResponseEntity.ok(ro);
    }

    @GetMapping(path = "/find-retout")
    public ResponseEntity<RetOutHis> findRO(@RequestParam String code) {
        log.info("/find-retout");
        RetOutHis sh = roService.findById(code);
        return ResponseEntity.ok(sh);
    }

    @GetMapping(path = "/get-retout-detail")
    public ResponseEntity<List<RetOutHisDetail>> getRODetail(@RequestParam String vouNo) {
        log.info("/get-retout-detail");
        List<RetOutHisDetail> listSD = rdService.search(vouNo);
        return ResponseEntity.ok(listSD);
    }
}