package com.tatsam.priority.service.impl;

import com.tatsam.priority.dao.RoleDao;
import com.tatsam.priority.dao.UserDao;
import com.tatsam.priority.dto.UserData;
import com.tatsam.priority.model.UserModel;
import com.tatsam.priority.service.UserService;
import com.tatsam.priority.utility.JwtTokenUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final static String USER_NOT_FOUND= "User with username %s is not found";

    private final static String BAD_CREDENTIALS= "bad credentials";

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userDao.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, userName)));
    }

    @Override
    public String addUser(UserData userData) {
        String encodedPass = bCryptPasswordEncoder.encode(userData.getPassword());
        userData.setPassword(encodedPass);
        UserModel reqUserModel = convertToEntity(userData);
        reqUserModel.setRole(roleDao.findByName(userData.getRole()));
        UserModel userModel  = userDao.save(reqUserModel);
        return jwtTokenUtil.generateToken(userModel);
    }

    @Override
    public String getTokenByUserNameAndPass(UserData userData) {
        if(userData.getUsername() != null && bCryptPasswordEncoder.matches(userData.getPassword(), loadUserByUsername(userData.getUsername())
                .getPassword())){
            return jwtTokenUtil.generateToken(convertToEntity(userData));
        }
        return BAD_CREDENTIALS;

    }

    private UserData convertToDto(UserModel userModel) {
        UserData userData = modelMapper.map(userModel, UserData.class);
        return userData;
    }

    private UserModel convertToEntity(UserData userData) throws ParseException {
        UserModel userModel = modelMapper.map(userData, UserModel.class);
        return userModel;
    }
}
