package com.huiyun;

public class Main {

    public static void main(String[] args) {
        DeskPhone myPhone = new DeskPhone(1234554);
	    myPhone.powerOn();
	    myPhone.callPhone(1234554);
	    myPhone.answer();

	    MobilePhone myMobilephone = new MobilePhone(43843);
        myMobilephone.powerOn();
        myMobilephone.callPhone(43843);
        myMobilephone.answer();

    }
}
