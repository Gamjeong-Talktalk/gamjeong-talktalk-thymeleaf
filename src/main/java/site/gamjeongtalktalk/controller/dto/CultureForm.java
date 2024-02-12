package site.gamjeongtalktalk.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CultureForm {

    private Long id;
    private String name;
    private int price;
    private String manager;
    private String date;
}
