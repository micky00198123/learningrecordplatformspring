package com.fina.lrps.domain;

/**
 * @author huangRui
 * @date 2019/10/23 22:14.
 */
public class NoticeForm {
    private String noticeId;
    private String content;
    private String laber;
    private String read;


    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLaber() {
        return laber;
    }

    public void setLaber(String laber) {
        this.laber = laber;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
}
