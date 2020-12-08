package com.example.gmail;

import android.support.v7.widget.CardView;
import android.widget.ImageButton;

public class EmailItem {

    private String sender;
    private String subject;
    private String brief;
    private String date;
    private boolean isImportant = false;

    public EmailItem(String sender, String subject, String brief, String date) {
        this.sender = sender;
        this.subject = subject;
        this.brief = brief;
        this.date = date;
//        this.star_.setTag(0);
    }

    public EmailItem(String sender, String subject, String brief, String date, boolean isImportant) {
        this.sender = sender;
        this.subject = subject;
        this.brief = brief;
        this.date = date;
        this.isImportant = isImportant;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public static EmailItem[] samples(){
        EmailItem[] emails = {
                new EmailItem("msonline", "Mã kiểm chứng",
                        "Kiểm chứng email", "2/12/2020"),
                new EmailItem("Roger", "Quảng cáo",
                        "Siêu phẩm công nghệ giảm sâu - Coupon đến 5TR!", "2/11/2020"),
                new EmailItem("Maria", "Quảng cáo",
                        "Machines can’t actually see, but Computer Vision techniques can bring artificial intelligence into the real world. ", "2/10/2020"),
                new EmailItem("Lucas", "QC",
                        "Siêu phẩm công nghệ giảm sâu - Coupon đến 5TR!", "2/9/2020"),
                new EmailItem("Bernardo", "Thông báo bảo mật",
                        "Tài khoản Google của bạn vừa được đăng nhập từ thiết bị Windows mới. Bạn nhận được email này vì chúng tôi muốn đảm bảo rằng đó chính là bạn.", "2/8/2020"),
                new EmailItem("Costa", "Your verification code",
                        "Your verification code is 245954", "2/7/2020"),
                new EmailItem("Pedro", "Cảnh báo bảo mật",
                        "Tài khoản Google của bạn vừa được đăng nhập từ thiết bị Windows mới. Bạn nhận được email này vì chúng tôi muốn đảm bảo rằng đó chính là bạn.", "2/6/2020"),
                new EmailItem("Luiz", "Cảnh báo bảo mật",
                        "Tài khoản Google của bạn vừa được đăng nhập từ thiết bị Windows mới. Bạn nhận được email này vì chúng tôi muốn đảm bảo rằng đó chính là bạn.", "2/5/2020"),
                new EmailItem("Ronaldo", "Cảnh báo bảo mật",
                        "This is your last chance to complete the 2020 Kaggle Machine Learning and Data Science survey!  The survey will be open for only a few more days! ", "2/4/2020"),
                new EmailItem("Ronaldo", "Quảng cáo",
                        "This is your last chance to complete the 2020 Kaggle Machine Learning and Data Science survey!  The survey will be open for only a few more days! ", "12/3/2020"),
                new EmailItem("Marcos", "Quảng cáo",
                        "Machines can’t actually see, but Computer Vision techniques can bring artificial intelligence into the real world. ", "2/2/2020"),
                new EmailItem("Maria", "Quảng cáo",
                        "Siêu phẩm công nghệ giảm sâu - Coupon đến 3TR!", "2/1/2020"),
        };

        return emails;
    }
}
