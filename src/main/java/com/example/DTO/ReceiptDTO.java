package com.example.DTO;

import java.time.LocalDate;

public class ReceiptDTO {

    private int receiptId;
    private LocalDate receiptDate;
    private double receiptAmount;
    private int paymentId;

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public double getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(double receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
