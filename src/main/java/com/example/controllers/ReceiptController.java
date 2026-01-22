package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DTO.ReceiptDTO;
import com.example.services.ReceiptService;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    // CREATE receipt (after payment success)
    @PostMapping
    public ReceiptDTO createReceipt(@RequestBody ReceiptDTO receiptDTO) {
        return receiptService.createReceipt(receiptDTO);
    }

    // READ receipt by id
    @GetMapping("/{id}")
    public ReceiptDTO getReceipt(@PathVariable int id) {
        return receiptService.getReceiptById(id);
    }

    // READ all receipts
    @GetMapping
    public List<ReceiptDTO> getAllReceipts() {
        return receiptService.getAllReceipts();
    }
}
