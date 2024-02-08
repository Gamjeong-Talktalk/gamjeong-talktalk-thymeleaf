package site.gamjeongtalktalk.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름이 유효하지 않습니다.")
    private String name;

    @NotEmpty(message = "회원 주소가 유효하지 않습니다.")
    private String address;

//    @NotEmpty(message = "회원 생일이 유효하지 않습니다.")
    private String birthday;

    @NotEmpty(message = "회원 연락처가 유효하지 않습니다.")
    private String phoneNumber;
}
