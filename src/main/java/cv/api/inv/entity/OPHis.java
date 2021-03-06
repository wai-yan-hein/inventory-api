package cv.api.inv.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "op_his")
public class OPHis implements java.io.Serializable {
    @Id
    @Column(name = "vou_no")
    private String vouNo;
    @Column(name = "op_date")
    @Temporal(TemporalType.DATE)
    private Date vouDate;
    @Column(name = "remark")
    private String remark;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "cur_code")
    private String curCode;
    @ManyToOne
    @JoinColumn(name = "loc_code")
    private Location location;
    @Column(name = "op_amt")
    private float opAmt;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Column(name = "deleted")
    private boolean deleted;
    @Column(name = "mac_id")
    private Integer macId;
    @Column(name = "comp_code")
    private String compCode;
    @Transient
    private List<OPHisDetail> detailList;
    @Transient
    private List<String> listDel;
    @Transient
    private String status = "STATUS";

}
