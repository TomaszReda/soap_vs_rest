package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.config;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.ws.soap.security.wss4j.callback.SimplePasswordValidationCallbackHandler;

import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import java.util.List;
import java.util.Properties;

/**
 * Configuration SOAP . .
 * @author Tomasz Reda
 * */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition userWsdl11Definition(XsdSchema userSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UsersPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("https://www.praca_magister/soap_vs_rest/users.com");
        wsdl11Definition.setSchema(userSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema userSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("xsd/user.xsd"));
    }


    @Bean(name = "books")
    public DefaultWsdl11Definition bookWsdl11Definition(XsdSchema bookSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BookPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("https://www.praca_magister/soap_vs_rest/books.com");
        wsdl11Definition.setSchema(bookSchema);
        return wsdl11Definition;
    }

    @Bean(name = "secure")
    public DefaultWsdl11Definition securewsdl11Definition(XsdSchema secureSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SecurePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("https://www.praca_magister/soap_vs_rest/secure.com");
        wsdl11Definition.setSchema(secureSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema secureSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/secure.xsd"));
    }

    @Bean(name = "test")
    public DefaultWsdl11Definition testwsdl11Definition(XsdSchema testSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TestPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("https://www.praca_magister/soap_vs_rest/test.com");
        wsdl11Definition.setSchema(testSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema testSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/test.xsd"));
    }


    @Bean
    public XsdSchema bookSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/book.xsd"));
    }

    @Bean
    public SimplePasswordValidationCallbackHandler securityCallbackHandler(){
        SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
        Properties users = new Properties();
        users.setProperty("admin", "secret");
        callbackHandler.setUsers(users);
        return callbackHandler;
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor(){
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationActions("Timestamp UsernameToken");
        securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
        return securityInterceptor;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }

}
