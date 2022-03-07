package dto.response;

import core.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class RemoveUserResponse {

    private List<CoreError> errors;

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveUserResponse that = (RemoveUserResponse) o;
        return Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public String toString() {
        return "RemoveUserResponse{" +
                "errors=" + errors +
                '}';
    }
}
