package com.workintech.FSWEBS18D4JavaProjesi.dto;

import java.util.List;

public record CustomerResponse(long id, String firstName, String lastName, String email, double salary, AddressResponse addressResponse,
                               List<AccountResponse> accountResponseList) {
}
