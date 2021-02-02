package pl.transmar.budowa.other;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
    private String search;

    public SearchDTO(String search) {
        this.search = search;
    }
}
