package com.jetty;


import java.io.Serializable;

/**
 * 
 */
public class SearchAccountRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    /** 账户ID */
    private Integer accountId;

    /** 账户编码（WY_XXX，JD_XXX，OTHER_XXX） */
    private String accountCode;

    /** 账号（WY 账户号，JD/JR 台账账号，OTHER其他账号） */
    private String accountNo;

    /** 账户名称 */
    private String accountName;

    /** 账户别名 */
    private String accountAlias;

    /** 通知人员（用户1ID|用户2ID|用户3ID） */
    private String receiver;

    @Override
    public String toString() {
        return "SearchAccountRequest{" +
                "accountId=" + accountId +
                ", accountCode='" + accountCode + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountAlias='" + accountAlias + '\'' +
                ", receiver='" + receiver + '\'' +
                '}';
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountAlias() {
        return accountAlias;
    }

    public void setAccountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
