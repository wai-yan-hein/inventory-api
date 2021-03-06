/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.controller;

import cv.api.common.FilterObject;
import cv.api.common.ReturnObject;
import cv.api.common.Util1;
import cv.api.inv.entity.StockInOut;
import cv.api.inv.entity.StockInOutDetail;
import cv.api.inv.service.ReportService;
import cv.api.inv.service.StockInOutDetailService;
import cv.api.inv.service.StockInOutService;
import cv.api.inv.view.VStockIO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wai yan
 */
@RestController
@RequestMapping("/stockio")
@Slf4j
public class StockInOutController {

    @Autowired
    private StockInOutService ioService;
    @Autowired
    private StockInOutDetailService iodService;
    @Autowired
    private ReportService reportService;
    private final ReturnObject ro = new ReturnObject();

    @PostMapping(path = "/save-stockio")
    public ResponseEntity<StockInOut> saveStockIO(@RequestBody StockInOut stockio, HttpServletRequest request) throws Exception {
        stockio = ioService.save(stockio);
        return ResponseEntity.ok(stockio);
    }

    @PostMapping(path = "/get-stockio")
    public ResponseEntity<List<VStockIO>> getStockIO(@RequestBody FilterObject filter) throws Exception {
        String fromDate = Util1.isNull(filter.getFromDate(), "-");
        String toDate = Util1.isNull(filter.getToDate(), "-");
        String vouNo = Util1.isNull(filter.getVouNo(), "-");
        String userCode = Util1.isNull(filter.getUserCode(), "-");
        String remark = Util1.isNull(filter.getRemark(), "-");
        String description = Util1.isNull(filter.getDescription(), "-");
        String vouStatus = Util1.isNull(filter.getVouStatus(), "-");
        String stockCode = Util1.isNull(filter.getStockCode(), "-");
        String compCode = filter.getCompCode();
        List<VStockIO> listStockIO = reportService.getStockIOHistory(fromDate, toDate, vouStatus, vouNo, remark, description, userCode, stockCode, compCode);
        return ResponseEntity.ok(listStockIO);
    }

    @DeleteMapping(path = "/delete-stockio")
    public ResponseEntity<ReturnObject> deleteStockIO(@RequestParam String code) throws Exception {
        ioService.delete(code);
        ro.setMessage("Deleted.");
        return ResponseEntity.ok(ro);
    }

    @GetMapping(path = "/find-stockio")
    public ResponseEntity<StockInOut> findStockIO(@RequestParam String code) {
        StockInOut sh = ioService.findById(code);
        return ResponseEntity.ok(sh);
    }

    @GetMapping(path = "/get-stockio-detail")
    public ResponseEntity<List<StockInOutDetail>> getStockIODetail(@RequestParam String vouNo) {
        List<StockInOutDetail> listSD = iodService.search(vouNo);
        return ResponseEntity.ok(listSD);
    }
}
