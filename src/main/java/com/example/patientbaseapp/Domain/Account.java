package com.example.patientbaseapp.Domain;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Account {
    private String Login;
    private String Password;
    private String Name;
}
