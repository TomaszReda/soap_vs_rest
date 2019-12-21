import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {

  model='@Slf4j\n' +
    '@Data\n' +
    '@Entity\n' +
    '@Getter\n' +
    '@Setter\n' +
    '@AllArgsConstructor\n' +
    '@NoArgsConstructor\n' +
    '@Table(name = "`user`")\n' +
    'public class User {\n' +
    '    @Id\n' +
    '    @GeneratedValue(strategy = GenerationType.IDENTITY)\n' +
    '    private Long id;\n' +
    '    private String firstname;\n' +
    '    private String lastname;\n' +
    '    private String email;\n' +
    '    private int phoneNumber;\n' +
    '    private String password;\n' +
    '    @ManyToOne\n' +
    '    @JoinColumn(name = "role_id")\n' +
    '    private UserRoles userRoles;\n' +
    '}\n';
  repository='@RepositoryRestResource\n' +
    'public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {\n' +
    '\n' +
    '    @Override\n' +
    '    default public void customize(QuerydslBindings bindings, QUser root) {\n' +
    '        bindings.bind(String.class).first(\n' +
    '                (StringPath path, String value) -> path.containsIgnoreCase(value));\n' +
    '    }\n' +
    '}\n';

  restController='@Controller\n' +
    '@RequestMapping("/api/rest/user")\n' +
    'public class UserControllerRest {\n' +
    '\n' +
    '    @Autowired\n' +
    '    UserServiceRest userService;\n' +
    '\n' +
    '    @PostMapping("/add")\n' +
    '    public ResponseEntity add(@RequestBody UserDto userDto) {\n' +
    '        return userService.add(userDto);\n' +
    '    }\n' +
    '}';
  restService='@Service\n' +
    'public class UserServiceRest {\n' +
    '\n' +
    '    @Autowired\n' +
    '    UserRepository userRepository;\n' +
    '\n' +
    '    @Autowired\n' +
    '    private UserMapper userMapper;\n' +
    '\n' +
    '    public ResponseEntity add(@RequestBody UserDto userDto) {\n' +
    '        User user = userMapper.ResttoUser(userDto);\n' +
    '        userRepository.save(user);\n' +
    '        return ResponseEntity.ok().build();\n' +
    '    }\n' +
    '}\n';
  restDto='@Data\n' +
    'public class UserDto {\n' +
    '    private Long Id;\n' +
    '    private String firstname;\n' +
    '    private String lastname;\n' +
    '    private String email;\n' +
    '    private int phoneNumber;\n' +
    '    private String password;\n' +
    '    private UserRoles userRoles;\n' +
    '\n' +
    '}';
  restMapper='@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)\n' +
    'public interface UserMapper {\n' +
    '    User ResttoUser(UserDto userDto);\n' +
    '}\n';

  soapMapper='@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)\n' +
    'public interface UserMapper {\n' +
    '    User SoapAddUserRequestToUser(soap.AddUserRequest addUserRequest);\n' +
    '}\n';
  soapCOntroller='@Endpoint\n' +
    'public class BookControllerSoap {\n' +
    '\n' +
    '    private static final String NAMESPACE_URI = "https://www.praca_magister/soap_vs_rest/books.com";\n' +
    '\n' +
    '    @Autowired\n' +
    '    private BookServiceSoap bookServiceSoap;\n' +
    '\n' +
    '    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddBookRequest")\n' +
    '    public void addBook(@RequestPayload soap.AddBookRequest request) {\n' +
    '        bookServiceSoap.addBook(request);\n' +
    '    }\n' +
    '}';
  soapCOnfig='@EnableWs\n' +
    '@Configuration\n' +
    'public class WebServiceConfig extends WsConfigurerAdapter {\n' +
    '\n' +
    '    @Bean\n' +
    '    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)\n' +
    '    {\n' +
    '        MessageDispatcherServlet servlet = new MessageDispatcherServlet();\n' +
    '        servlet.setApplicationContext(applicationContext);\n' +
    '        servlet.setTransformWsdlLocations(true);\n' +
    '        return new ServletRegistrationBean(servlet, "/ws/*");\n' +
    '    }\n' +
    '\n' +
    '    @Bean(name = "users")\n' +
    '    public DefaultWsdl11Definition userWsdl11Definition(XsdSchema userSchema)\n' +
    '    {\n' +
    '        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();\n' +
    '        wsdl11Definition.setPortTypeName("UsersPort");\n' +
    '        wsdl11Definition.setLocationUri("/ws");\n' +
    '        wsdl11Definition.setTargetNamespace("https://www.praca_magister/soap_vs_rest/users.com");\n' +
    '        wsdl11Definition.setSchema(userSchema);\n' +
    '        return wsdl11Definition;\n' +
    '    }\n' +
    '\n' +
    '    @Bean\n' +
    '    public XsdSchema userSchema()\n' +
    '    {\n' +
    '        return new SimpleXsdSchema(new ClassPathResource("xsd/user.xsd"));\n' +
    '    }\n' +
    '}\n';
  soapService='@Service\n' +
    'public class BookServiceSoap {\n' +
    '\n' +
    '    @Autowired\n' +
    '    private BookRepository bookRepository;\n' +
    '\n' +
    '    @Autowired\n' +
    '    private BookMapper bookMapper;\n' +
    '\n' +
    '    public void addBook(soap.AddBookRequest request) {\n' +
    '        Book book = bookMapper.SoapAddBookRequestToBook(request);\n' +
    '        LocalDate localDate = LocalDate.of(\n' +
    '                request.getData().getYear(),\n' +
    '                request.getData().getMonth(),\n' +
    '                request.getData().getDay());\n' +
    '        book.setDate(localDate);\n' +
    '        bookRepository.save(book);\n' +
    '    }\n' +
    '}';
  soapPlikWSD='<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="https://www.praca_magister/soap_vs_rest/users.com"\n' +
    '           targetNamespace="https://www.praca_magister/soap_vs_rest/users.com" elementFormDefault="qualified">\n' +
    '\n' +
    '    <xs:element name="AddUserRequest">\n' +
    '        <xs:complexType>\n' +
    '            <xs:sequence>\n' +
    '                <xs:element name="firstname" type="xs:string"/>\n' +
    '                <xs:element name="lastname" type="xs:string"/>\n' +
    '                <xs:element name="email" type="xs:string"/>\n' +
    '                <xs:element name="phoneNumber" type="xs:string"/>\n' +
    '                <xs:element name="password" type="xs:string"/>\n' +
    '                <xs:element name="userRoles" type="tns:UserRoles"/>\n' +
    '            </xs:sequence>\n' +
    '        </xs:complexType>\n' +
    '    </xs:element>\n' +
    '    \n' +
    '    <xs:complexType name="UserRoles">\n' +
    '        <xs:sequence>\n' +
    '            <xs:element name="id" type="xs:long"/>\n' +
    '            <xs:element name="userRole" type="tns:UserRoleEnum"/>\n' +
    '        </xs:sequence>\n' +
    '    </xs:complexType>\n' +
    '\n' +
    '    <xs:simpleType name="UserRoleEnum">\n' +
    '        <xs:restriction base="xs:string">\n' +
    '            <xs:enumeration value="ADMIN"/>\n' +
    '            <xs:enumeration value="CASUAL_USER"/>\n' +
    '        </xs:restriction>\n' +
    '    </xs:simpleType>\n' +
    '</xs:schema>';
  restTEXT21='';
  restTEXT22='';
  r

  constructor() { }

  ngOnInit() {
  }

}
