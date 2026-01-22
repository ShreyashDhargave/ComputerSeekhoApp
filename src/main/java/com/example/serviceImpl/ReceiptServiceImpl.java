package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.ReceiptDTO;
import com.example.entities.Payment;
import com.example.entities.Receipt;
import com.example.repositories.PaymentRepository;
import com.example.repositories.ReceiptRepositories;
import com.example.services.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepositories receiptRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public ReceiptDTO createReceipt(ReceiptDTO dto) {

        Payment payment = paymentRepository.findById(dto.getPaymentId())
                .orElseThrow(() -> new RuntimeException("payment not found"));

        Receipt receipt = new Receipt();
        receipt.setReceiptDate(dto.getReceiptDate());
        receipt.setReceiptAmount(dto.getReceiptAmount());
        receipt.setPaymentId(payment);

        Receipt saved = receiptRepository.save(receipt);

        dto.setReceiptId(saved.getReceiptId());
        return dto;
    }

    @Override
    public ReceiptDTO getReceiptById(int receiptId) {

        Receipt receipt = receiptRepository.findById(receiptId)
                .orElseThrow(() -> new RuntimeException("receipt not found"));

        ReceiptDTO dto = new ReceiptDTO();
        dto.setReceiptId(receipt.getReceiptId());
        dto.setReceiptDate(receipt.getReceiptDate());
        dto.setReceiptAmount(receipt.getReceiptAmount());
        dto.setPaymentId(receipt.getPaymentId().getPaymentId());

        return dto;
    }

    @Override
    public List<ReceiptDTO> getAllReceipts() {

        return receiptRepository.findAll().stream().map(receipt -> {
            ReceiptDTO dto = new ReceiptDTO();
            dto.setReceiptId(receipt.getReceiptId());
            dto.setReceiptDate(receipt.getReceiptDate());
            dto.setReceiptAmount(receipt.getReceiptAmount());
            dto.setPaymentId(receipt.getPaymentId().getPaymentId());
            return dto;
        }).collect(Collectors.toList());
    }
}
