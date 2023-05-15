package be.syntra.auction.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @CreationTimestamp
    private LocalDateTime timestamp;
    @NonNull
    private List<String> message;

}
