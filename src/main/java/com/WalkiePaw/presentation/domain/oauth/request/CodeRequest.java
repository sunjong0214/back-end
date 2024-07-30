package com.WalkiePaw.presentation.domain.oauth.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeRequest {
    private String code;
    private String provider;
}
