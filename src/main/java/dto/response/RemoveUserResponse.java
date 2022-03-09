package dto.response;

import core.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class RemoveUserResponse {

    private List<CoreError> errors;
    private boolean removedAccount;

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    public boolean isRemovedAccount() {
        return removedAccount;
    }

    public void setRemovedAccount(boolean removedAccount) {
        this.removedAccount = removedAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveUserResponse that = (RemoveUserResponse) o;
        return removedAccount == that.removedAccount && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, removedAccount);
    }

    @Override
    public String toString() {
        return "RemoveUserResponse{" +
                "errors=" + errors +
                ", removedAccount=" + removedAccount +
                '}';
    }
}
