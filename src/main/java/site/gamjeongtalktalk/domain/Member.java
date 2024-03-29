package site.gamjeongtalktalk.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.util.UUID.randomUUID;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "t_member")
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String address;
    private String birthday;
    private String phoneNumber;
    private String invitationCode;

    @Builder
    private Member(
            String name,
            String address,
            String birthday,
            String phoneNumber
    ) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.invitationCode = generateInvitationCode();
    }

    public static Member createMember(
            String name,
            String address,
            String birthday,
            String phoneNumber
    ) {
        return Member.builder()
                .name(name)
                .address(address)
                .birthday(birthday)
                .phoneNumber(phoneNumber)
                .build();
    }

    //== Business Method ==//
    private String generateInvitationCode() {
        return randomUUID().toString().substring(0, 6);
    }
}
