package com.chenhai.educationsystem.vo;

import com.chenhai.educationsystem.domain.RenewRecord;

import java.util.List;

public class RenewResult {
    private String flag = "true";
    private List<RenewRecord> renew;

    public RenewResult(List<RenewRecord> renew) {
        this.renew = renew;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<RenewRecord> getRenew() {
        return renew;
    }

    public void setRenew(List<RenewRecord> renew) {
        this.renew = renew;
    }
}
