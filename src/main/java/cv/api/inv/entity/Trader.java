/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "trader")
public class Trader implements java.io.Serializable {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;
    @Column(name = "comp_code")
    private String compCode;
    @Column(name = "trader_name")
    private String traderName;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "reg_code")
    private Region region;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private boolean active;
    @Column(name = "remark")
    private String remark;
    @Column(name = "parent")
    private String parent;
    @Column(name = "app_short_name")
    private String appShortName; //use integration with other application
    @Column(name = "app_trader_code")
    private String appTraderCode; //Original trader id from integration app
    @Column(name = "mig_code")
    private String migCode;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "mac_id")
    private Integer macId;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "credit_days")
    private Integer creditLimit;
    @Column(name = "credit_limit")
    private Integer creditDays;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "type")
    private String type;
    @Column(name = "cash_down")
    private boolean cashDown;
    @Column(name = "multi")
    private boolean multi;
    @Column(name = "intg_upd_status")
    private String intgUpdStatus;

}
