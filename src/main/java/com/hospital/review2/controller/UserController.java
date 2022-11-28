package com.hospital.review2.controller;


import com.hospital.review2.domain.Response;
import com.hospital.review2.domain.dto.UserDto;
import com.hospital.review2.domain.dto.UserJoinRequest;
import com.hospital.review2.domain.dto.UserJoinResponse;
import com.hospital.review2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    
    //Response 추상화 - 에러코드를 포함시켜 리턴
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest userJoinRequest) {

        UserDto userDto = userService.join(userJoinRequest);

        return Response.suceess(new UserJoinResponse(userDto.getUserName(),userDto.getEmail()));
    }
}
