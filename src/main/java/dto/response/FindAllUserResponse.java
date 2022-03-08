package dto.response;

import dto.UserEntityDTO;

import java.util.List;
import java.util.Objects;

public class FindAllUserResponse {

    private List<UserEntityDTO> userEntityDTOList;

    public FindAllUserResponse(List<UserEntityDTO> userEntityDTOList) {
        this.userEntityDTOList = userEntityDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindAllUserResponse that = (FindAllUserResponse) o;
        return Objects.equals(userEntityDTOList, that.userEntityDTOList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEntityDTOList);
    }

    @Override
    public String toString() {
        return "FindAllUserResponse{" +
                "userEntityDTOList=" + userEntityDTOList +
                '}';
    }
}
