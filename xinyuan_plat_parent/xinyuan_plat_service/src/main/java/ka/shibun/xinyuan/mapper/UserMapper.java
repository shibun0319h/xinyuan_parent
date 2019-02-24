package ka.shibun.xinyuan.mapper;

import java.util.List;
import ka.shibun.xinyuan.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}