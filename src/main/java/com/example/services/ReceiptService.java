package com.example.services;

import java.util.List;
import com.example.DTO.ReceiptDTO;

public interface ReceiptService {

    ReceiptDTO createReceipt(ReceiptDTO receiptDTO);

    ReceiptDTO getReceiptById(int receiptId);

    List<ReceiptDTO> getAllReceipts();
}
