package com.finteen.finteenserver.domain.user.controller;

import com.finteen.finteenserver.domain.user.docs.UserDocs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements UserDocs {
}