package cv.api.common;

import lombok.Data;

@Data
public class ClosingBalance {
    private String typeUserCode;
    private String typeName;
    private String stockUsrCode;
    private String stockCode;
    private String stockName;
    private String vouNo;
    private String vouDate;
    private float openQty;
    private float openAmt;
    private String openRel;
    private float purQty;
    private float purAmt;
    private String purRel;
    private float inQty;
    private float inAmt;
    private String inRel;
    private float outQty;
    private float outAmt;
    private String outRel;
    private float saleQty;
    private float saleAmt;
    private String saleRel;
    private float balQty;
    private float closingAmt;
    private String balRel;
    private String groupName;
    private String remark;
}
