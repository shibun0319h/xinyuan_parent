package ka.shibun.xinyuan.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ka.shibun.xinyuan.domain.User;
import ka.shibun.xinyuan.mapper.UserMapper;
import ka.shibun.xinyuan.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shibun
 * @since 2019-02-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
