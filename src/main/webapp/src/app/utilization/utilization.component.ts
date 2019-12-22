import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-utilization',
  templateUrl: './utilization.component.html',
  styleUrls: ['./utilization.component.css']
})
export class UtilizationComponent implements OnInit {

  rest='@RestController\n' +
    '@RequestMapping("/api/")\n' +
    'public class RestSoapController {\n' +
    '\n' +
    '    @Autowired\n' +
    '    private UserRepository userRepository;\n' +
    '\n' +
    '    @PostMapping("rest_to_soap/delete/user/{id}")\n' +
    '    public void a(@RequestBody DeleteUserRequest deleteUserRequest) throws Exception {\n' +
    '        Optional<User> user = userRepository.findById(deleteUserRequest.getId());\n' +
    '        if (user.isPresent()) {\n' +
    '            userRepository.delete(user.get());\n' +
    '        }\n' +
    '    }\n' +
    '}\n';
  constructor() { }

  ngOnInit() {
  }

}
