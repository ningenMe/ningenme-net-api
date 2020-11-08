package ningenme.net.api.domain.value;

import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "e-mailの値オブジェクト")
public class Email {

    private static final Integer MAX_LENGTH = 100;
    private static final Pattern REGEX_PATTERN = Pattern.compile("[A-Za-z0-9\\-.\\_]+@[A-Za-z0-9\\-.\\_]+\\.[A-Za-z]+");

    @JsonProperty("email")
    @ApiModelProperty(value = "email", example = "amohkuru@gmail.com")
    @NonNull
    private final String value;

    public static Email of(@NonNull String email) throws NullPointerException,IllegalArgumentException {
        
        if(REGEX_PATTERN.matcher(email).matches() 
        && email.length() <= MAX_LENGTH) {
            return new Email(email);
        }
        
        throw new IllegalArgumentException("Illegal email" + email);
    }

    @Override
    public String toString() {
        return value;
    }
}
