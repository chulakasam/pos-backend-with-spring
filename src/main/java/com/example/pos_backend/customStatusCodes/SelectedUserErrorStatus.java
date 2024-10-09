package com.example.pos_backend.customStatusCodes;

import com.example.pos_backend.Dto.status.CustomerStatus;
import com.example.pos_backend.Dto.status.ItemStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserErrorStatus implements CustomerStatus, ItemStatus {
    private int statusCode;
    private String statusMessage;
}
