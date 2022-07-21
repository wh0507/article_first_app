package com.example.firstproject.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberFormDto {

    @NotBlank(message = "名前の入力は必須です。")
    private String name;

    @NotEmpty(message = "メールアドレスの入力は必須です。")
    @Email(message = "xxxx@xxxx.xxxx")
    private String email;

    @NotEmpty(message = "パスワードの入力は必須です。")
    @Length(min=8, max=16, message = "パスワードは8文字以上、16文字以下で入力してください。")
    private String password;

    @NotEmpty(message = "住所の入力は必須です。")
    private String address;

}
