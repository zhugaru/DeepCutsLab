package zhugaru.dcl.mapsctruct.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDto {
    private Long artistId;
    private String artistName;
}
