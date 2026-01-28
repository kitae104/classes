package kim.kitae.chap11.ex0;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class BookLombok {
    private int bookNumber;
    private String bookTitle;
}
